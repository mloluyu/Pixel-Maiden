package top.chinuomlo.pixelmaiden.event.client;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import top.chinuomlo.pixelmaiden.Registies;
import top.chinuomlo.pixelmaiden.block.DollShelfEntityRenderer;

import static top.chinuomlo.pixelmaiden.PixelMaiden.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEventListener {
    @SubscribeEvent
    public static void registerBlockEntityRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(Registies.doll_shelf_entity.get(), DollShelfEntityRenderer::new);
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(Registies.doll_shelf.get(), RenderType.cutout());
    }
}
