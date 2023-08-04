package net.jingkaishi.mineassistantmod.common.tileentities;

import net.jingkaishi.mineassistantmod.MineAssistantMod;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, MineAssistantMod.MOD_ID);

    public static void register() {
        TILE_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
