package net.jingkaishi.mineassistantmod.common.tileentities.custom;

import net.jingkaishi.mineassistantmod.common.tileentities.ModTileEntities;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import java.io.IOException;


public class HologramTileEntity extends TileEntity {


    private final ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler);

    public HologramTileEntity(TileEntityType<?> hologramTileEntityTileEntityType) {
        super(hologramTileEntityTileEntityType);
    }



    @Override
    public CompoundNBT save(CompoundNBT nbt) {
        nbt.put("inv", itemHandler.serializeNBT());
        return super.save(nbt);
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        itemHandler.deserializeNBT(nbt.getCompound("inv"));
        super.load(state, nbt);
    }

    public CompoundNBT write(CompoundNBT nbt) {
        nbt.put("inv", itemHandler.serializeNBT());
        return HologramTileEntity.super.save(nbt);
    }

    public HologramTileEntity() {
        super(ModTileEntities.HOLOGRAM.get());
    }

    private ItemStackHandler createHandler(){
        return new ItemStackHandler(2){
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                switch (slot){
                    case 0: return stack.getItem() == Items.WRITABLE_BOOK;
                    case 1: return stack.getItem() == Items.WRITABLE_BOOK;
                    default:
                        return true;
                }
            }

            @Override
            public int getSlotLimit(int slot) {
                return 2;
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


    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap) {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return handler.cast();
        }
        return super.getCapability(cap);
    }

    //TODO: Write the method to call for GPT-3 API if the given slot has a ink and book item, extract the content of it, process it to be a prompt, and print the result in the terminal
    public void onPromptReceived(PlayerEntity player){
        boolean checkSlotOneValid = itemHandler.getStackInSlot(0).getCount() > 0
                && itemHandler.getStackInSlot(0).getItem() == Items.WRITABLE_BOOK;
        boolean checkSlotTwoValid = itemHandler.getStackInSlot(1).getCount() > 0
                && itemHandler.getStackInSlot(1).getItem() == Items.WRITABLE_BOOK;
        if(checkSlotOneValid && checkSlotTwoValid){
            ItemStack promptBook = itemHandler.getStackInSlot(0);
            ItemStack keyBook = itemHandler.getStackInSlot(1);
            // do something magical and call GPT

            String prompt = extractTextFromBook(promptBook);
            String apiKey = extractTextFromBook(keyBook);

            try {
                String response = callGPTAPI(prompt, apiKey);
                player.sendMessage(new StringTextComponent(response), player.getUUID());
            } catch (IOException e) {
                // This assumes an IOException would signify a connection error.
                // Adjust as necessary based on the exceptions thrown by your callGPTAPI method.
                player.sendMessage(new StringTextComponent("It seems like it failed to connect, let's check my internet connection real quick..."), player.getUUID());
            } catch (Exception e) {
                // Catch other exceptions that may indicate an invalid API key, rate limits, etc.
                player.sendMessage(new StringTextComponent("It seems like there are some error when the hologram tried to process this, let's just make sure that my rate is still up and my key is correct..."), player.getUUID());
            }
        }
    }


    private String extractTextFromBook(ItemStack book) {
        // Extract text content from the book. Adjust as per your actual method of extraction.
        return "";
    }

    private String callGPTAPI(String prompt, String apiKey) throws Exception {
        // Your GPT-3 API call method, which uses the provided apiKey
        return "";
    }
}