package com.ysmhmcgames.ihc_more_ore.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class AnalysisRoomScreen extends AbstractContainerScreen<AnalysisRoomMenu> {
    public AnalysisRoomScreen(AnalysisRoomMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }
    
    private static final ResourceLocation ANALYSIS_ROOM_GUI_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID,"textures/gui/analysis_room_gui.png");
    private static final ResourceLocation PROGRESS_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID,"textures/gui/progress.png");

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        RenderSystem.enableBlend();// 设置半透明渲染
        RenderSystem.defaultBlendFunc();// 设置半透明渲染
        RenderSystem.setShader(GameRenderer::getPositionTexShader);// 设置着色器
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1f);// 设置着色器颜色
        RenderSystem.setShaderTexture(0, ANALYSIS_ROOM_GUI_TEXTURE);// 设置着色器纹理

        /*
         * width -> 屏幕宽
         * height -> 屏幕高
         * imageWidth -> 图片宽
         * imageHeight -> 图片高
         * */
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        guiGraphics.blit(ANALYSIS_ROOM_GUI_TEXTURE,x,y,0,0,imageWidth,imageHeight);

        renderProgress(guiGraphics,x,y);
    }

    private void renderProgress(GuiGraphics guiGraphics,int x,int y){// 自定义方法:绘制进度"箭头"
        if(menu.isCrafting()){
            guiGraphics.blit(PROGRESS_TEXTURE, x + 79, y + 27, 0, 0, 17, menu.getScaledPProgressProgress(), 17, 32);
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics,mouseX,mouseY);
    }
}
