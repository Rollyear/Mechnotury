package com.roystain.mechnotury.common.group;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import com.roystain.mechnotury.common.registry.ItemRegistry;

public class BasicItemGroup extends ItemGroup {
    public BasicItemGroup(){
        super("basic_item_group");
    }
    @Override
    public ItemStack createIcon(){
        return new ItemStack(ItemRegistry.unitEmpty.get());
    }
}

