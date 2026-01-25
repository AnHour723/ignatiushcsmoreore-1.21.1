package com.ysmhmcgames.ihc_more_ore.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class SoulAltarScreen extends AbstractContainerScreen<SoulAltarMenu> {
    public SoulAltarScreen(SoulAltarMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    private static final ResourceLocation SOUL_ALTAR_GUI_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID,"textures/gui/soul_altar_gui.png");

    private static final ResourceLocation PROGRESS_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID,"textures/gui/soul_altar_progress.png");




    @Override// 渲染背景  pPartialTick -> 部分刻度  ,  pMouseX、pMouseY  ->  鼠标位置
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);// 设置着色器
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);// 设置着色器颜色
        RenderSystem.setShaderTexture(0, SOUL_ALTAR_GUI_TEXTURE);// 设置着色器纹理
        /*
         * width -> 屏幕宽
         * height -> 屏幕高
         * imageWidth -> 图片宽
         * imageHeight -> 图片高
         * */
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        guiGraphics.blit(SOUL_ALTAR_GUI_TEXTURE,x,y,0,0,imageWidth,imageHeight);

        renderProgress(guiGraphics,x,y);
    }


    private void renderProgress(GuiGraphics guiGraphics,int x,int y){// 自定义方法:绘制进度"箭头"
        if(menu.isCrafting()){
            guiGraphics.blit(PROGRESS_TEXTURE, x + 78, y + 33, 0, 0, 20, menu.getScaledPProgressProgress(), 20, 20);
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics,mouseX,mouseY);
    }
}
