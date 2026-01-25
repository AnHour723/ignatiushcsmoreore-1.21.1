package com.ysmhmcgames.ihc_more_ore.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import com.ysmhmcgames.ihc_more_ore.IgnatiusHCsMoreOre;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;

import java.util.ArrayList;
import java.util.List;

public class WeaponPlatformScreen extends AbstractContainerScreen<WeaponPlatformMenu> {
    private static final ResourceLocation WEAPON_PLATFORM_GUI_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID,"textures/gui/weapon_platform_gui.png");

    private static final ResourceLocation PROGRESS_TEXTURE =
            ResourceLocation.fromNamespaceAndPath(IgnatiusHCsMoreOre.MODID,"textures/gui/weapon_platform_progress.png");



    public WeaponPlatformScreen(WeaponPlatformMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);// 设置着色器
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);// 设置着色器颜色
        RenderSystem.setShaderTexture(0, WEAPON_PLATFORM_GUI_TEXTURE);// 设置着色器纹理
        /*
         * width -> 屏幕宽
         * height -> 屏幕高
         * imageWidth -> 图片宽
         * imageHeight -> 图片高
         * */
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        guiGraphics.blit(WEAPON_PLATFORM_GUI_TEXTURE,x,y,0,0,imageWidth,imageHeight);

        renderProgress(guiGraphics,x,y);
    }

    private void renderProgress(GuiGraphics guiGraphics,int x,int y){// 自定义方法:绘制进度"箭头"
        if(menu.isCrafting()){
            guiGraphics.blit(PROGRESS_TEXTURE, x + 122, y + 28, 0, 0, menu.getScaledPProgressProgress(), 24, 24, 24);
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics,mouseX,mouseY);



    }
}
