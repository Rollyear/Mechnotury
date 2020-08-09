package com.roystain.mechnotury.common.registry;

import com.roystain.mechnotury.common.block.machine.forgingtable.ForgingTableTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypeRegistry {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, "mechnotury");
    public static RegistryObject<TileEntityType<ForgingTableTileEntity>> forgingTableTileEntity = TILE_ENTITIES
            .register("forging_table_tileentity", () -> {
        return TileEntityType.Builder.create(() -> new ForgingTableTileEntity(), BlockRegistry.forgingTable.get()).build(null);
    });
}
