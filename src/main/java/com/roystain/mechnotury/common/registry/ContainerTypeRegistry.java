package com.roystain.mechnotury.common.registry;

import com.roystain.mechnotury.common.block.machine.forgingtable.ForgingContainer;
import com.roystain.mechnotury.common.block.machine.forgingtable.ForgingContainerItemNumber;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerTypeRegistry {
    public static final DeferredRegister<ContainerType<?>> CONTAINERS = new DeferredRegister<>(ForgeRegistries.CONTAINERS, "mechnotury");
    public static RegistryObject<ContainerType<ForgingContainer>> forgingContainer = CONTAINERS.register("forging_container", () -> IForgeContainerType.create((int windowId, PlayerInventory inv, PacketBuffer data) -> {
        return new ForgingContainer(windowId, inv, data.readBlockPos(), Minecraft.getInstance().world.getWorld(), new ForgingContainerItemNumber());
    }));
}
