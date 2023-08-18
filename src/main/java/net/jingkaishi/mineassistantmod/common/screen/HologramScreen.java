package net.jingkaishi.mineassistantmod.common.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.jingkaishi.mineassistantmod.MineAssistantMod;
import net.jingkaishi.mineassistantmod.common.container.HologramContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class HologramScreen extends ContainerScreen<HologramContainer> {

    private final ResourceLocation GUI = new ResourceLocation(MineAssistantMod.MOD_ID,
            "textures/gui/hologram_screen_gui.png");
    public HologramScreen(HologramContainer container, PlayerInventory inv, ITextComponent component) {
        super(container, inv, component);
    }

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void renderBg(MatrixStack stack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1f, 1f, 1f, 1f);
        this.minecraft.getTextureManager().bind(GUI);
        int i = this.getGuiLeft();
        int j = this.getGuiTop();
        this.blit(stack, i, j, 0, 0, this.getXSize(), this.getYSize());
    }
}
