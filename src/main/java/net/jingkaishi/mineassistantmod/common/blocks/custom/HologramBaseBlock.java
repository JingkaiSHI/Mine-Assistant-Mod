package net.jingkaishi.mineassistantmod.common.blocks.custom;

import net.jingkaishi.mineassistantmod.MineAssistantMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.material.Material;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.world.IBlockReader;
import net.jingkaishi.mineassistantmod.common.tileentities.ModTileEntities;


public class HologramBaseBlock extends Block {

    public static final DirectionProperty FACING = HorizontalBlock.FACING;

    public HologramBaseBlock() {
        super(Properties.of(Material.METAL));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
        this.setRegistryName(MineAssistantMod.MOD_ID, "hologram_base_block");
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.HOLOGRAM.get().create();
    }
}
