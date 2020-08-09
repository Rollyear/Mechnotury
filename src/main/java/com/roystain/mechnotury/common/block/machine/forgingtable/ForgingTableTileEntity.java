package com.roystain.mechnotury.common.block.machine.forgingtable;

import com.roystain.mechnotury.common.registry.TileEntityTypeRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nullable;
import java.util.Objects;

public class ForgingTableTileEntity extends TileEntity {
    public ForgingTableTileEntity(){
        super(TileEntityTypeRegistry.forgingTableTileEntity.get());
    }

    private ItemStack itemStack = ItemStack.EMPTY;

    public ItemStack getItemStack() {
        return itemStack;
    }

    public ItemStack pushItemStack() {
        ItemStack result = itemStack.copy();
        itemStack = ItemStack.EMPTY;
        markDirty();
        Objects.requireNonNull(world).notifyBlockUpdate(this.pos, this.getBlockState(), this.getBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
        return result;
    }
    public void popItemStack(ItemStack itemStack) {
        this.itemStack = itemStack.copy();
        markDirty();
        Objects.requireNonNull(world).notifyBlockUpdate(this.pos, this.getBlockState(), this.getBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
    }
    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(pos, 1, getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        handleUpdateTag(pkt.getNbtCompound());
    }

    @Override
    public CompoundNBT getUpdateTag() {
        CompoundNBT compoundNBT = super.getUpdateTag();
        itemStack.write(compoundNBT);
        return compoundNBT;
    }

    @Override
    public void handleUpdateTag(CompoundNBT tag) {
        this.itemStack = ItemStack.read(tag).copy();
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        CompoundNBT tag = new CompoundNBT();
        tag = this.itemStack.write(tag);
        compound.put("item", tag);
        return super.write(compound);
    }

    @Override
    public void read(CompoundNBT compound) {
        CompoundNBT tag = compound.getCompound("item");
        this.itemStack = ItemStack.read(tag);
        super.read(compound);
    }
}
