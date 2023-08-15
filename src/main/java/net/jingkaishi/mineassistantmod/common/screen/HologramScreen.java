package net.jingkaishi.mineassistantmod.common.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.jingkaishi.mineassistantmod.common.container.HologramContainer;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.text.ITextComponent;

public class HologramScreen extends ContainerScreen<HologramContainer> {
    public HologramScreen(HologramContainer container, PlayerInventory inv, ITextComponent component) {
        super(container, inv, component);
    }

    @Override
    protected void renderBg(MatrixStack stack, float partialTicks, int x, int y) {

    }
}
