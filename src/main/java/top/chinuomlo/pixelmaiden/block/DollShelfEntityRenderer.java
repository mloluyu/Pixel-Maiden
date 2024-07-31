package top.chinuomlo.pixelmaiden.block;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import static top.chinuomlo.pixelmaiden.Registies.doll_shelf_entity;

public class DollShelfEntityRenderer implements BlockEntityRenderer<DollShelfEntity> {

    public DollShelfEntityRenderer(BlockEntityRendererProvider.Context pContext) {
    }

    @Override
    public void render(DollShelfEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        pBlockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER).ifPresent(iItemHandler -> {
            ItemStack itemStack = iItemHandler.getStackInSlot(0);
            if (!itemStack.isEmpty()) {
                var itemrenderer = Minecraft.getInstance().getItemRenderer();
                pPoseStack.pushPose();
                itemrenderer .renderStatic(itemStack, ItemDisplayContext.FIXED, LightTexture.FULL_BRIGHT, pPackedOverlay, pPoseStack, pBuffer, Minecraft.getInstance().level, 0);
                pPoseStack.popPose();
            }
        });
    }

    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(doll_shelf_entity.get(), DollShelfEntityRenderer::new);
    }
}
