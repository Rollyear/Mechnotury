package com.roystain.mechnotury.common.block.basicblock;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class SiliconBlock extends Block {
    public SiliconBlock() {
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(5f)
                .hardnessAndResistance(5,1200)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(2)
                .sound(SoundType.METAL)
        );
    }
    //Height State
}
