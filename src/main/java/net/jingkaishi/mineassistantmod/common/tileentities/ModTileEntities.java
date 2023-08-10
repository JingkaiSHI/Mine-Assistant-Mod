package net.jingkaishi.mineassistantmod.common.tileentities;

import net.jingkaishi.mineassistantmod.MineAssistantMod;
import net.jingkaishi.mineassistantmod.common.blocks.ModBlocks;
import net.jingkaishi.mineassistantmod.common.tileentities.custom.HologramTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MineAssistantMod.MOD_ID);

    public static final RegistryObject<TileEntityType<HologramTileEntity>> HOLOGRAM = TILE_ENTITIES.register("hologram",
            () -> TileEntityType.Builder.of(() -> new HologramTileEntity(), ModBlocks.HOLOGRAM_BASE_BLOCK.get()).build(null));

    public static void register(IEventBus eventBus) {
        TILE_ENTITIES.register(eventBus);
    }
}
