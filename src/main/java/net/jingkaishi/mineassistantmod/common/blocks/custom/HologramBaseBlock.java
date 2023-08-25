package net.jingkaishi.mineassistantmod.common.blocks.custom;

import net.jingkaishi.mineassistantmod.MineAssistantMod;
import net.jingkaishi.mineassistantmod.common.container.HologramContainer;
import net.jingkaishi.mineassistantmod.common.tileentities.custom.HologramTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.jingkaishi.mineassistantmod.common.tileentities.ModTileEntities;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;


public class HologramBaseBlock extends Block {



    public HologramBaseBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTileEntities.HOLOGRAM.get().create();
    }

    @Override
    public ActionResultType use(BlockState blockState, World worldIn, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult traceResult) {
        if(!worldIn.isClientSide()){
            TileEntity tileEntity = worldIn.getBlockEntity(pos);

            if(!player.isCrouching()){
                if(tileEntity instanceof HologramTileEntity){
                    INamedContainerProvider provider = createContainerProvider(worldIn, pos);
                    NetworkHooks.openGui(((ServerPlayerEntity) player), provider, tileEntity.getBlockPos());
                    ((HologramTileEntity)tileEntity).onPromptReceived(player);
                }else{
                    throw new IllegalStateException("our container provider is missing!");
                }
            }else{
                if(tileEntity instanceof HologramTileEntity){
                    EntityType.LIGHTNING_BOLT.spawn(((ServerWorld) worldIn), null, player,
                            pos, SpawnReason.TRIGGERED, true, true);
                }
            }
        }

        return ActionResultType.SUCCESS;
    }

    private INamedContainerProvider createContainerProvider(World worldIn, BlockPos pos){
        return new INamedContainerProvider() {
            @Override
            public ITextComponent getDisplayName() {
                return new TranslationTextComponent("screen.mineassistantmod.hologram_base_block");
            }

            @Nullable
            @Override
            public Container createMenu(int i, PlayerInventory playerInventory, PlayerEntity player) {
                return new HologramContainer(i, worldIn, pos, playerInventory, player);
            }
        };
    }
}
