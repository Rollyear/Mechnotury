package com.roystain.mechnotury.common.block.machine.forgingtable;

import com.roystain.mechnotury.common.registry.TileEntityTypeRegistry;
import net.minecraft.tileentity.TileEntity;

public class ForgingTableTileEntity extends TileEntity {
    public ForgingTableTileEntity(){
        super(TileEntityTypeRegistry.forgingTableTileEntity.get());
    }
}