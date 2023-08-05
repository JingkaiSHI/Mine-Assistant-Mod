package net.jingkaishi.mineassistantmod.common.items;

import net.jingkaishi.mineassistantmod.MineAssistantMod;
import net.jingkaishi.mineassistantmod.common.blocks.ModBlocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.jingkaishi.mineassistantmod.common.tabs.ModCreativeTabs;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MineAssistantMod.MOD_ID);

    public static final RegistryObject<Item> HOLOGRAM_BASE_ITEM = ITEMS.register("hologram_base_block",
            () -> new BlockItem(ModBlocks.HOLOGRAM_BASE_BLOCK.get(), new Item.Properties().tab(ModCreativeTabs.MOD_TAB)));

    public static void register() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
