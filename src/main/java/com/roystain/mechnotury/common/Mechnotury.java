package com.roystain.mechnotury.common;

import com.roystain.mechnotury.common.registry.TileEntityTypeRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import com.roystain.mechnotury.common.registry.BlockRegistry;
import com.roystain.mechnotury.common.registry.ItemRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("mechnotury")
public class Mechnotury {
    //mod的ID字符串，用于材质包获取id，或其他用途
    public static final  String modId = "mechnotury";
    public Mechnotury(){
        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        ItemRegistry.ITEMS.register(modbus);
        BlockRegistry.BLOCKS.register(modbus);
        TileEntityTypeRegistry.TILE_ENTITIES.register(modbus);
    }
}

