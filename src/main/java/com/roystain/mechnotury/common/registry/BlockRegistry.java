package com.roystain.mechnotury.common.registry;

import com.roystain.mechnotury.common.block.basicblock.MoissaniteOre;
import com.roystain.mechnotury.common.block.basicblock.SiliconBlock;
import com.roystain.mechnotury.common.block.basicblock.SteelBlock;
import com.roystain.mechnotury.common.block.machine.forgingtable.ForgingTable;
import com.roystain.mechnotury.common.block.material.BoardProcessing;
import com.roystain.mechnotury.common.block.material.BoardStorage;
import com.roystain.mechnotury.common.block.others.EnergeticFlower;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, "mechnotury");
    //Basic Block
    public static RegistryObject<Block> steelBlock = BLOCKS.register("steel_block", SteelBlock::new);
    public static RegistryObject<Block> siliconBlock = BLOCKS.register("silicon_block", SiliconBlock::new);
    public static RegistryObject<Block> moissaniteOre = BLOCKS.register("moissanite_ore", MoissaniteOre::new);
    //others
    public static RegistryObject<Block> energeticFlower = BLOCKS.register("energetic_flower", EnergeticFlower::new);
    //Machine
    public static RegistryObject<Block> forgingTable = BLOCKS.register("forging_table", ForgingTable::new);
    //Material
    public static RegistryObject<Block> boardProcessing = BLOCKS.register("board_processing", BoardProcessing::new);
    public static RegistryObject<Block> boardStorage = BLOCKS.register("board_storage", BoardStorage::new);
}

