package com.roystain.mechnotury.common.group;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import com.roystain.mechnotury.common.registry.ItemRegistry;

public class ToolGroup extends ItemGroup {
    public ToolGroup(){
        super("tool_group");
    }
    @Override
    public ItemStack createIcon(){
        return new ItemStack(ItemRegistry.cuttingWeldingGun.get());
    }
}
