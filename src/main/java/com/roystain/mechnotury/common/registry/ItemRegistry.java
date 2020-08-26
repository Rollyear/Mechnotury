package com.roystain.mechnotury.common.registry;

import com.roystain.mechnotury.common.group.BasicItem;
import com.roystain.mechnotury.common.group.Tool;
import com.roystain.mechnotury.common.item.basicitem.*;
import com.roystain.mechnotury.common.item.material.*;
import com.roystain.mechnotury.common.item.spacedome.InitialSpaceDome;
import com.roystain.mechnotury.common.item.spacedome.MediumSpaceDome;
import com.roystain.mechnotury.common.item.spacedome.TheGreatestSpaceDome;
import com.roystain.mechnotury.common.item.tools.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, "mechnotury");
                  //Block Items
    //Basic Blocks
    public static RegistryObject<Item> steelBlock = ITEMS.register("steel_block", () -> new BlockItem(BlockRegistry.steelBlock.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
    public static RegistryObject<Item> siliconBlock =ITEMS.register("silicon_block",() -> new BlockItem(BlockRegistry.siliconBlock.get(),new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
    public static RegistryObject<Item> moissaniteOre =ITEMS.register("moissanite_ore",() -> new BlockItem(BlockRegistry.moissaniteOre.get(),new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
    //others
    public static RegistryObject<Item> energeticFlower =ITEMS.register("energetic_flower",() -> new BlockItem(BlockRegistry.energeticFlower.get(),new Item.Properties().group(ItemGroup.DECORATIONS)));
    //Machine
    public static RegistryObject<Item> forgingTable =ITEMS.register("forging_table",() -> new BlockItem(BlockRegistry.forgingTable.get(),new Item.Properties().group(Tool.itemGroup)));
    //Material
    public static RegistryObject<Item> boardProcessing =ITEMS.register("board_processing",() -> new BlockItem(BlockRegistry.boardProcessing.get(),new Item.Properties().group(BasicItem.itemGroup)));
    public static RegistryObject<Item> boardStorage =ITEMS.register("board_storage",() -> new BlockItem(BlockRegistry.boardStorage.get(),new Item.Properties().group(BasicItem.itemGroup)));
                 //Items
    //Basic Items
    public static RegistryObject<Item> steelIngot = ITEMS.register("steel_ingot", SteelIngot::new);
    public static RegistryObject<Item> grade1CoarseSilicon = ITEMS.register("grade1_coarse_silicon", Grade1CoarseSilicon::new);
    public static RegistryObject<Item> grade2CoarseSilicon = ITEMS.register("grade2_coarse_silicon", Grade2CoarseSilicon::new);
    public static RegistryObject<Item> niceSilicon = ITEMS.register("nice_silicon", NiceSilicon::new);
    public static RegistryObject<Item> moissanite = ITEMS.register("moissanite", Moissanite::new);
    //Material
    public static RegistryObject<Item> unitEmpty = ITEMS.register("unit_empty", UnitEmpty::new);
    public static RegistryObject<Item> unitEnergy = ITEMS.register("unit_energy", UnitEnergy::new);
    public static RegistryObject<Item> unitReaction = ITEMS.register("unit_reaction", UnitReaction::new);
    public static RegistryObject<Item> unitStorage = ITEMS.register("unit_storage", UnitStorage::new);
    public static RegistryObject<Item> steelSheet = ITEMS.register("steel_sheet", SteelSheet::new);
    public static RegistryObject<Item> siliconSheet = ITEMS.register("silicon_sheet", SiliconSheet::new);
    //Tools and Weapons
    public static RegistryObject<Item> steelHammer = ITEMS.register("steel_hammer", SteelHammer::new);
    public static RegistryObject<Item> welderMask = ITEMS.register("welder_mask", WelderMask::new);
    public static RegistryObject<Item> cuttingWeldingGun = ITEMS.register("cutting_welding_gun", CuttingWeldingGun::new);
    public static RegistryObject<Item> initialSpaceDome = ITEMS.register("initial_space_dome", InitialSpaceDome::new);
    public static RegistryObject<Item> mediumSpaceDomeSpaceDome = ITEMS.register("medium_space_dome", MediumSpaceDome::new);
    public static RegistryObject<Item> theGreatestSpaceDome = ITEMS.register("the_greatest_space_dome", TheGreatestSpaceDome::new);

}

