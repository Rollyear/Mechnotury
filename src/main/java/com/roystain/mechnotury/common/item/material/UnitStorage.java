package com.roystain.mechnotury.common.item.material;

import net.minecraft.item.Item;
import com.roystain.mechnotury.common.group.BasicItem;

public class UnitStorage extends Item {
    public UnitStorage(){
        super(new Properties()
                .group(BasicItem.itemGroup));
    }
}
