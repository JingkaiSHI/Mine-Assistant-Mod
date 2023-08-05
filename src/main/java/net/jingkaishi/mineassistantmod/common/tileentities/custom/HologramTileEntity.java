package net.jingkaishi.mineassistantmod.common.tileentities.custom;

import net.jingkaishi.mineassistantmod.common.tileentities.ModTileEntities;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.jingkaishi.mineassistantmod.MineAssistantMod;
import net.jingkaishi.mineassistantmod.common.blocks.ModBlocks;

public class HologramTileEntity extends TileEntity implements ITickableTileEntity {

    public HologramTileEntity() {
        super(ModTileEntities.HOLOGRAM.get());
    }

    @Override
    public void tick() {
        // Here goes the animation logic
    }
}