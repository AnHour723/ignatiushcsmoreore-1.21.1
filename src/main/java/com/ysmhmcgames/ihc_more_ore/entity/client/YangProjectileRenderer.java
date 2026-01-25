package com.ysmhmcgames.ihc_more_ore.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import com.ysmhmcgames.ihc_more_ore.entity.custom.YangProjectileEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

public class YangProjectileRenderer extends EntityRenderer<YangProjectileEntity> {
    private YangProjectileModel model;

    public YangProjectileRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new YangProjectileModel(context.bakeLayer(YangProjectileModel.LAYER_LOCATION));
    }



    @Override
    public void render(YangProjectileEntity pEntity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();

        VertexConsumer vertexConsumer = ItemRenderer.getFoilBufferDirect(
                buffer, this.model.renderType(this.getTextureLocation(pEntity)), false, false);
        this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);

        poseStack.popPose();
        super.render(pEntity, entityYaw, partialTick, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(YangProjectileEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID, "textures/entity/arrow/yang_arrow.png");
    }
}
