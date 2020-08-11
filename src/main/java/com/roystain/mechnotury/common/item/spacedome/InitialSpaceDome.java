package com.roystain.mechnotury.common.item.spacedome;

import net.minecraft.item.Item;
import com.roystain.mechnotury.common.group.Tool;

public class InitialSpaceDome extends Item {
    public InitialSpaceDome(){
        super(new Properties()
                .maxStackSize(1)
                .group(Tool.itemGroup));
    }
}
