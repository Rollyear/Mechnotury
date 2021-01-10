package com.roystain.mechnotury.common.block.machine.forgingtable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

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
    //Hitting Box
    private static final VoxelShape shape;
    static {
        VoxelShape top1 = Block.makeCuboidShape(1, 14, 1, 15, 15, 15);
        VoxelShape top2 = Block.makeCuboidShape(2, 13, 2, 14, 14, 14);
        VoxelShape pillar= Block.makeCuboidShape(6, 4, 6, 10, 13, 10);
        VoxelShape bottom = Block.makeCuboidShape(4, 3, 4, 12, 4, 12);
        VoxelShape base = Block.makeCuboidShape(3, 0, 3, 13, 3, 13);
        shape = VoxelShapes.or(top1,top2,pillar,bottom,base);
    }
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return shape;
    }
    //Facing set
    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.FACING);
    }
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return getDefaultState().with(BlockStateProperties.FACING, context.getNearestLookingDirection().getOpposite());
    }
    //TileEntity 设置
    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }
    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new ForgingTableTileEntity();
    }
}


