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
import net.minecraftforge.common.ToolType;


public class HologramBaseBlock extends Block {

    public static final DirectionProperty FACING = HorizontalBlock.FACING;

    public HologramBaseBlock() {
        super(Properties.of(Material.METAL).harvestLevel(2).harvestTool(ToolType.PICKAXE).requiresCorrectToolForDrops());
    }
}
