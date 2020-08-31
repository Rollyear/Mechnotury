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
    //???
    public ItemStack itemStack = ItemStack.EMPTY;
    //渲染方面的东西
    public ForgingTableTileEntity(){
        super(TileEntityTypeRegistry.forgingTableTileEntity.get());
    }
    //读入NBT
    @Override
    public void read(CompoundNBT compound) {
        CompoundNBT tag = compound.getCompound("item");
        this.itemStack = ItemStack.read(tag);
        super.read(compound);
    }
    //写入NBT
    @Override
    public CompoundNBT write(CompoundNBT compound) {
        CompoundNBT tag = new CompoundNBT();
        tag = this.itemStack.write(tag);
        compound.put("item", tag);
        return super.write(compound);
    }
    //服务端->客户端
    @Nullable
    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(pos, 1, getUpdateTag());
    }
    //区块刚刚被加载时，服务端->客户端
    @Override
    public CompoundNBT getUpdateTag() {
        CompoundNBT compoundNBT = super.getUpdateTag();
        itemStack.write(compoundNBT);
        return compoundNBT;
    }
    //客户端接收数据包
    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        super.onDataPacket(net,pkt);
        handleUpdateTag(pkt.getNbtCompound());
    }
    @Override
    public void handleUpdateTag(CompoundNBT tag) {
        this.itemStack = ItemStack.read(tag).copy();
    }
    //获取物品信息
    public ItemStack getItemStack() {
        return itemStack;
    }
    //放入物品
    public ItemStack pushItemStack() {
        ItemStack result = itemStack.copy();
        itemStack = ItemStack.EMPTY;
        markDirty();
        Objects.requireNonNull(world).notifyBlockUpdate(this.pos, this.getBlockState(),
                this.getBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
        return result;
    }
    //取出物品
    public void popItemStack(ItemStack itemStack) {
        this.itemStack = itemStack.copy();
        markDirty();
        Objects.requireNonNull(world).notifyBlockUpdate(this.pos, this.getBlockState(),
                this.getBlockState(), Constants.BlockFlags.BLOCK_UPDATE);
    }
}