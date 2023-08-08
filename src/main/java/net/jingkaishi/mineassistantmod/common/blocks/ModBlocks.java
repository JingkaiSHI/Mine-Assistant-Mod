package net.jingkaishi.mineassistantmod.common.blocks;

import net.jingkaishi.mineassistantmod.MineAssistantMod;
import net.jingkaishi.mineassistantmod.common.items.ModItems;
import net.jingkaishi.mineassistantmod.common.tabs.ModCreativeTabs;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.jingkaishi.mineassistantmod.common.blocks.custom.HologramBaseBlock;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MineAssistantMod.MOD_ID);

    public static final RegistryObject<Block> HOLOGRAM_BASE_BLOCK = registerBlock("hologram_base_block",
            () -> new HologramBaseBlock(AbstractBlock.Properties.of(Material.METAL)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()));


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(ModCreativeTabs.MOD_TAB)));
    }

    public static void register() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
