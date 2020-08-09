package com.roystain.mechnotury.common.registry;

import com.roystain.mechnotury.common.block.machine.forgingtable.ForgingTer;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEventHandler {
    @SubscribeEvent
    public static void onClientEvent(FMLClientSetupEvent event) {
        ClientRegistry.bindTileEntityRenderer(TileEntityTypeRegistry.forgingTableTileEntity.get(),
                (ForgingTer::new)
        );
    }
}
