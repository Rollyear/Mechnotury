package com.roystain.mechnotury.common.block.machine.forgingtable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.Objects;

public class ForgingTable extends Block {
    public ForgingTable() {
        super(Properties.create(Material.ANVIL)
                .hardnessAndResistance(5f)
                .hardnessAndResistance(5,1200)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(2)
                .sound(SoundType.METAL)
                .notSolid()
        );
    }
    //TileEntity
    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new ForgingTableTileEntity();
    }
    //Voxel Shape
    private static VoxelShape shape;
    static {
        VoxelShape topb = Block.makeCuboidShape(1, 14, 1, 15, 15, 15);
        VoxelShape topc = Block.makeCuboidShape(2, 13, 2, 14, 14, 14);
        VoxelShape pillar= Block.makeCuboidShape(6, 4, 6, 10, 13, 10);
        VoxelShape bottom = Block.makeCuboidShape(4, 3, 4, 12, 4, 12);
        VoxelShape base = Block.makeCuboidShape(3, 0, 3, 13, 3, 13);
        shape = VoxelShapes.or(topb,topc,pillar,bottom,base);
    }
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return shape;
    }
    //Put and Pop Item
    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos,
                                             PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote && handIn == Hand.MAIN_HAND) {
            ForgingTableTileEntity tileEntity = (ForgingTableTileEntity) Objects.requireNonNull(worldIn.getTileEntity(pos));
            if (player.getItemStackFromSlot(EquipmentSlotType.MAINHAND).isEmpty()) {
                player.setItemStackToSlot(EquipmentSlotType.MAINHAND, tileEntity.pushItemStack());
            } else if (tileEntity.getItemStack().isEmpty()) {
                ItemStack putItem = player.getItemStackFromSlot(EquipmentSlotType.MAINHAND).copy();
                putItem.setCount(1);
                tileEntity.popItemStack(putItem);
                player.getItemStackFromSlot(EquipmentSlotType.MAINHAND).shrink(1);
            }
        }
        return ActionResultType.SUCCESS;
    }
    //Facing State
    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.FACING);
    }
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return getDefaultState().with(BlockStateProperties.FACING, context.getNearestLookingDirection().getOpposite());
    }
}


