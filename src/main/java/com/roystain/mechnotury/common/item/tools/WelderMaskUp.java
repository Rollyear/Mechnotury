package com.roystain.mechnotury.common.item.tools;

import net.minecraft.item.Item;
import com.roystain.mechnotury.common.group.Tool;

public class WelderMaskUp extends Item {
    public WelderMaskUp(){
        super(new Properties()
                .maxStackSize(1)
                .group(Tool.itemGroup));
    }
}
