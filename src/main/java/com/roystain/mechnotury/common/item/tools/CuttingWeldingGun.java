package com.roystain.mechnotury.common.item.tools;

import com.roystain.mechnotury.common.group.Tool;
import net.minecraft.item.Item;

public class CuttingWeldingGun extends Item {
    public CuttingWeldingGun(){
        super(new Properties()
                .maxStackSize(1)
                .group(Tool.itemGroup));
    }
}
