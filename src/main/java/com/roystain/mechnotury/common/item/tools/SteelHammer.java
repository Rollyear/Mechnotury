package com.roystain.mechnotury.common.item.tools;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import com.roystain.mechnotury.common.group.Tool;
import com.roystain.mechnotury.common.registry.ItemRegistry;

public class SteelHammer extends SwordItem {
    private static IItemTier iItemTier = new IItemTier() {
        @Override
        public int getMaxUses() {
            return 2000;
        }
        @Override
        public float getEfficiency() {
            return 10.0F;
        }
        @Override
        public float getAttackDamage() {
            return 5.0F;
        }
        @Override
        public int getHarvestLevel() {
            return 3;
        }
        @Override
        public int getEnchantability() {
            return 50;
        }
        @Override
        public Ingredient getRepairMaterial() {
            return Ingredient.fromItems(ItemRegistry.steelIngot.get());
        }
    };
    public SteelHammer() {
        super(iItemTier, 3, -3F, new Item.Properties()
                        .group(Tool.itemGroup)
        );
    }
}
