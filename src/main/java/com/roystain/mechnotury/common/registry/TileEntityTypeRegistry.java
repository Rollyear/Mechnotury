package com.roystain.mechnotury.common.registry;

import com.roystain.mechnotury.common.Mechnotury;
import com.roystain.mechnotury.common.Utils;
import com.roystain.mechnotury.common.block.machine.forgingtable.ForgingTableTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypeRegistry {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Utils.MOD_ID);    public static RegistryObject<TileEntityType<ForgingTableTileEntity>> forgingTableTileEntity =
            TILE_ENTITIES.register("forging_table", () -> TileEntityType.Builder.create(
            ForgingTableTileEntity::new, BlockRegistry.forgingTable.get()).build(null));
}
