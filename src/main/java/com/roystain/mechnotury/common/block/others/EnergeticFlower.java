package com.roystain.mechnotury.common.block.others;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class EnergeticFlower extends Block {
    public EnergeticFlower() {
        super(Properties.create(Material.PLANTS)
                .hardnessAndResistance(1f)
                .hardnessAndResistance(1,1200)
                .sound(SoundType.PLANT)
                .doesNotBlockMovement()
                .notSolid()
        );
    }
    private static VoxelShape shape;
    static {
        VoxelShape base = Block.makeCuboidShape(6, 0, 6, 10, 10, 10);
        shape = VoxelShapes.or(base);
    }
    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return shape;
    }
}