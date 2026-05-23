package com.ysmhmcgames.ihc_more_ore.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.effect.HCEffects;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

// 模型渲染类
public class TranslucentLivingLayer<T extends LivingEntity, M extends EntityModel<T>> extends RenderLayer<T, M> {


    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID, "textures/render/white.png");

    public TranslucentLivingLayer(RenderLayerParent<T, M> renderer) {
        super(renderer);
    }


//    @Override
//    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource bufferSource, int packedLight,
//                       AbstractClientPlayer player, float limbSwing, float limbSwingAmount,
//                       float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {// 实体渲染层，每帧调用
//
//        // ResourceLocation skin = player.getSkin().texture();
//
//        if (!shouldRender(player)) {
//            return;
//        }
//
//        // 获取混合图片(纯色)
//        VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityTranslucent(TEXTURE));
//
//        // renderToBuffer是 Minecraft 渲染系统的核心方法之一，它的唯一职责是：把模型（Model / ModelPart）的顶点数据，提交到 GPU 缓冲区，真正画出来 ————> 解析来自deepseek
//        // poseStack-变换矩阵栈      packedLight-光照信息   覆盖层（Overlay）-OverlayTexture
//        this.getParentModel().renderToBuffer(poseStack, vertexConsumer, packedLight,
//                OverlayTexture.NO_OVERLAY,0x5500ffff);
//    }
//
//    private boolean shouldRender(AbstractClientPlayer player) {
//        return player.hasEffect(HCEffects.QUANTIFICATION_EFFECT);
//    }

    @Override
    public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int packedLight, T entity,
                       float limbSwing,
                       float limbSwingAmount,
                       float partialTick,
                       float ageInTicks,
                       float netHeadYaw,
                       float headPitch) {

    }
}
