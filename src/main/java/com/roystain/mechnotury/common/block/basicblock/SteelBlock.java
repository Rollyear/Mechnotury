package com.roystain.mechnotury.common.block.basicblock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

import static net.minecraft.block.SnowBlock.LAYERS;

public class SteelBlock extends Block {
    public SteelBlock() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(5f)
                .hardnessAndResistance(5, 1200)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(2)
                .sound(SoundType.METAL)
        );
    }
    //Height State
}
