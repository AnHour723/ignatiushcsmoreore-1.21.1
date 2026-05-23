package com.ysmhmcgames.ihc_more_ore.item.tools.custom.miscellaneous;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.RelativeMovement;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HomecomingItem extends Item {
    public HomecomingItem(Properties properties) {
        super(properties);
    }
    private static ServerLevel serverLevel = null;

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, Player player, @NotNull InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!level.isClientSide()) {
            // 获取出生点
            BlockPos spawnPoint = getSpawnPoint(player);
            //System.out.println(spawnPoint);
            ResourceKey<Level> dimension = player.level().dimension();

            if (spawnPoint != null) {
                // 传送玩家
                teleportPlayer(player, spawnPoint);

                if(((ServerPlayer)player).gameMode.getGameModeForPlayer() != GameType.CREATIVE){
                    // 设置CD
                    player.getCooldowns().addCooldown(this, 3000);
                }
                // 消耗物品
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }


                // 播放效果
                playTeleportEffects(level, player);

                return InteractionResultHolder.success(stack);
            } else {
                // 发送消息
                player.displayClientMessage(
                        Component.translatable("text.home_coming.warning").withStyle(ChatFormatting.DARK_RED),
                        true
                );
                // 没有出生点的情况
                return InteractionResultHolder.fail(stack);
            }
        }

        return InteractionResultHolder.pass(stack);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

        tooltipComponents.add(Component.translatable("item_text.home_coming.info").withColor(0xFFFFFF));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    /**
     * 获取玩家出生点
     */
    private BlockPos getSpawnPoint(Player player) {
        // 1. 尝试获取玩家个人出生点（床的出生点）
        if (player instanceof ServerPlayer serverPlayer) {
            BlockPos bedSpawn = serverPlayer.getRespawnPosition();  // 使用 ServerPlayer
            if (bedSpawn != null) {
                return bedSpawn;
            }
        }

        // 2. 获取世界出生点
        if (player instanceof ServerPlayer serverPlayer) {
            serverLevel = serverPlayer.server.getLevel(player.getCommandSenderWorld().dimension());
            if (serverLevel != null) {
                return serverLevel.getSharedSpawnPos();
            }
        }

        return null;
    }

    /**
     * 传送玩家
     */
    private void teleportPlayer(Player player, BlockPos spawnPoint) {
        // 寻找安全的站立位置
        BlockPos safeSpawn = findSafeSpawn(player.level(), spawnPoint);

        // 执行传送
        player.teleportTo(
                player.getServer().getLevel(Level.OVERWORLD),
                safeSpawn.getX() + 0.5,
                safeSpawn.getY(),
                safeSpawn.getZ() + 0.5,
                RelativeMovement.ALL,
                player.getYRot(), player.getXRot()
        );

        // 防止摔落伤害
        player.fallDistance = 0;

        // 发送消息
        player.displayClientMessage(
                Component.translatable("text.home_coming.info").withStyle(ChatFormatting.GREEN),
                true
        );
    }

    /**
     * 寻找安全的出生点位置
     */
    private BlockPos findSafeSpawn(Level level, BlockPos pos) {
        // 检查当前位置是否安全
        if (isSafeSpawn(level, pos)) {
            return pos;
        }

        // 在周围寻找安全位置
        for (int radius = 1; radius <= 5; radius++) {
            for (int x = -radius; x <= radius; x++) {
                for (int z = -radius; z <= radius; z++) {
                    BlockPos checkPos = pos.offset(x, 0, z);
                    if (isSafeSpawn(level, checkPos)) {
                        return checkPos;
                    }
                }
            }
        }

        // 如果没有找到安全位置，返回原始位置上方
        return new BlockPos(pos.getX(), level.getHeight(), pos.getZ());
    }

    /**
     * 检查位置是否安全
     */
    private boolean isSafeSpawn(Level level, BlockPos pos) {
        // 检查站立方块
        BlockState floor = level.getBlockState(pos.below());
        if (floor.isAir() || !floor.isSolidRender(level, pos.below())) {
            return false;
        }

        // 检查站立空间
        BlockState feet = level.getBlockState(pos);
        BlockState head = level.getBlockState(pos.above());

        return feet.isAir() && head.isAir();
    }

    /**
     * 播放传送特效
     */
    private void playTeleportEffects(Level level, Player player) {
        // 传送起点特效
        spawnTeleportParticles(level, player.position());

        // 传送音效
        level.playSound(null, player.blockPosition(),
                SoundEvents.ENDERMAN_TELEPORT,
                SoundSource.PLAYERS, 1.0f, 1.0f);
    }

    /**
     * 生成传送粒子
     */
    private void spawnTeleportParticles(Level level, Vec3 pos) {
        if (level instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ParticleTypes.PORTAL,
                    pos.x, pos.y, pos.z,
                    50, 0.5, 1.0, 0.5, 0.2);

            serverLevel.sendParticles(ParticleTypes.REVERSE_PORTAL,
                    pos.x, pos.y, pos.z,
                    30, 0.5, 1.0, 0.5, 0.1);
        }
    }




}
