package com.ysmhmcgames.ihc_more_ore.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class DisplayStandScreen extends AbstractContainerScreen<DisplayStandMenu> {
    private static final ResourceLocation DISPLAY_STAND_GUI_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID,"textures/gui/display_stand_gui.png");

    public DisplayStandScreen(DisplayStandMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override// 渲染背景  pPartialTick -> 部分刻度  ,  pMouseX、pMouseY  ->  鼠标位置
    protected void renderBg(GuiGraphics guiGraphics, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);// 设置着色器
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);// 设置着色器颜色
        RenderSystem.setShaderTexture(0, DISPLAY_STAND_GUI_TEXTURE);// 设置着色器纹理
        /*
        * width -> 屏幕宽
        * height -> 屏幕高
        * imageWidth -> 图片宽
        * imageHeight -> 图片高
        * */
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        guiGraphics.blit(DISPLAY_STAND_GUI_TEXTURE,x,y,0,0,imageWidth,imageHeight);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics,mouseX,mouseY);
    }
}
