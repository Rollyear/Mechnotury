package com.roystain.mechnotury.common.block.machine.forgingtable;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;

public class ForgingTER extends TileEntityRenderer<ForgingTableTileEntity> {
    public ForgingTER(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
    }
    @Override
    public void render(ForgingTableTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        matrixStackIn.push();
        matrixStackIn.rotate(Vector3f.XP.rotationDegrees(90.0F));
        matrixStackIn.translate(0.5, 0.5, -0.95);
        matrixStackIn.scale(0.5f, 0.5f, 0.5f);
        //判断方向旋转物品
        /*switch (facing) {
            case north:matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(0.0F));
            case south:matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(180.0F));
            case west:matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(-90.0F));
            case east:matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90.0F));
        }*/
        ItemRenderer itemRenderer = Minecraft.getInstance().getItemRenderer();
        ItemStack stack = tileEntityIn.getItemStack();
        IBakedModel ibakedmodel = itemRenderer.getItemModelWithOverrides(stack, tileEntityIn.getWorld(), null);
        itemRenderer.renderItem(stack, ItemCameraTransforms.TransformType.FIXED,
                true, matrixStackIn, bufferIn, combinedLightIn, combinedOverlayIn, ibakedmodel);
        matrixStackIn.pop();
    }
}
