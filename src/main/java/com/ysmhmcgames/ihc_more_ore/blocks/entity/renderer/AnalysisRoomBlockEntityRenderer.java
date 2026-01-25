package com.ysmhmcgames.ihc_more_ore.blocks.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.ysmhmcgames.ihc_more_ore.blocks.entity.AnalysisRoomBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;

public class AnalysisRoomBlockEntityRenderer implements BlockEntityRenderer<AnalysisRoomBlockEntity> {

    public AnalysisRoomBlockEntityRenderer(BlockEntityRendererProvider.Context context){

    }

    @Override
    public void render(AnalysisRoomBlockEntity analysisRoomBlockEntity, float v, PoseStack poseStack,
                       MultiBufferSource multiBufferSource, int i, int i1) {
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();// 从客户端获取物品渲染器
        ItemStack stack = analysisRoomBlockEntity.inventory.getStackInSlot(1);// 要渲染的物品来自于方块实体里的库存 槽位为1的位置
        if(stack.isEmpty()){
            stack = analysisRoomBlockEntity.inventory.getStackInSlot(0);// 如果槽位栏1的位置为空 则渲染槽位为0的位置
        }


        poseStack.pushPose();// 推送到后栈  -->  表面我们要渲染某个东西  (开始记录要渲染的东西)
        poseStack.translate(0.5f,0.5f,0.5f);// 渲染位置
        poseStack.scale(0.3f,0.3f,0.3f);// 缩放比例
        // 旋转 旋转轴体为Y轴 rotationDegrees --> 输入我们想旋转的角度
        poseStack.mulPose(Axis.YP.rotationDegrees(analysisRoomBlockEntity.getRenderingRotation()));

        // 使用 renderStatic 方法直接进行渲染
        itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED,// FIXED --> 为如同物品掉落物一样渲染
                getLightLevel(analysisRoomBlockEntity.getLevel(), analysisRoomBlockEntity.getBlockPos()),
                OverlayTexture.NO_OVERLAY,poseStack,multiBufferSource,analysisRoomBlockEntity.getLevel(),1);
        poseStack.popPose();// 弹出后栈堆  -->  意味着要渲染前文所有内容  (结束记录并渲染记录的要渲染的东西)

    }

    private int getLightLevel(Level level, BlockPos pos) {// 自定义方法 获取光源的方法 --> 计算当前光照级别
        int bLight = level.getBrightness(LightLayer.BLOCK,pos);
        int sLight = level.getBrightness(LightLayer.SKY,pos);
        return LightTexture.pack(bLight,sLight);
    }
}
