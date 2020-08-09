package com.roystain.mechnotury.common.item.tools;

import com.roystain.mechnotury.common.group.Tool;
import net.minecraft.item.Item;

public class TheGreatestSpaceDome extends Item {
    public TheGreatestSpaceDome(){
        super(new Properties()
                .maxStackSize(1)
                .group(Tool.itemGroup));
    }
}
