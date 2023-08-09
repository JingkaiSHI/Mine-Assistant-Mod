package net.jingkaishi.mineassistantmod.common.tileentities.custom;

import net.jingkaishi.mineassistantmod.common.tileentities.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.jingkaishi.mineassistantmod.MineAssistantMod;
import net.jingkaishi.mineassistantmod.common.blocks.ModBlocks;

import javax.annotation.Nonnull;


public class HologramTileEntity extends TileEntity {

    public HologramTileEntity() {
        super(ModTileEntities.HOLOGRAM.get());
    }

    private ItemStackHandler createHandler(){
        return new ItemStackHandler(1){


            // do the save
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                switch (slot){
                    case 0: return stack.getItem() == Items.WRITABLE_BOOK;
                    default:
                        return false;
                }
            }

            @Override
            public int getSlotLimit(int slot) {
                return 1;
            }

            @Nonnull
            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate) {
                if(!isItemValid(slot, stack)){
                    return stack;
                }
                return super.insertItem(slot, stack, simulate);
            }
        };
    }


}