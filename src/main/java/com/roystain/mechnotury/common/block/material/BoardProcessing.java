package com.roystain.mechnotury.common.block.material;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BoardProcessing extends Block {
    public BoardProcessing(){
        super(Properties.create(Material.IRON)
                .hardnessAndResistance(5f)
                .hardnessAndResistance(1,1)
                .harvestLevel(1)
                .sound(SoundType.SNOW)
        );
    }
}
