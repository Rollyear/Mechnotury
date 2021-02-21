package com.roystain.mechnotury.common;

import com.roystain.mechnotury.common.registry.TileEntityTypeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import com.roystain.mechnotury.common.registry.ItemRegistry;
import com.roystain.mechnotury.common.registry.BlockRegistry;

@Mod(Utils.MOD_ID)
public class Mechnotury {
    public Mechnotury(){
        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemRegistry.ITEMS.register(modbus);
        BlockRegistry.BLOCKS.register(modbus);
        TileEntityTypeRegistry.TILES.register(modbus);
    }
}

