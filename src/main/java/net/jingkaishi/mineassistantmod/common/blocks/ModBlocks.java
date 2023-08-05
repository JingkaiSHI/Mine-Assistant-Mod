package net.jingkaishi.mineassistantmod.common.blocks;

import net.jingkaishi.mineassistantmod.MineAssistantMod;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.jingkaishi.mineassistantmod.common.blocks.custom.HologramBaseBlock;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MineAssistantMod.MOD_ID);

    public static final RegistryObject<HologramBaseBlock> HOLOGRAM_BASE_BLOCK = BLOCKS.register("hologram_base_block",
            () -> new HologramBaseBlock());

    public static void register() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}
