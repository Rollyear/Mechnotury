package com.roystain.mechnotury.common.item.material;

import net.minecraft.item.Item;
import com.roystain.mechnotury.common.group.BasicItem;

public class UnitEmpty extends Item {
    public UnitEmpty(){
        super(new Properties()
                .group(BasicItem.itemGroup));
    }
}

