package top.chinuomlo.pixelmaiden.entity.std_doll;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static top.chinuomlo.pixelmaiden.PixelMaiden.MODID;
import static top.chinuomlo.pixelmaiden.Registies.STANDARD_DOLL;
import static top.chinuomlo.pixelmaiden.entity.std_doll.StandardDollModel.*;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class StandardDollRender extends MobRenderer<StandardDoll, StandardDollModel<StandardDoll>> {

    public static final ResourceLocation TEX = new ResourceLocation(MODID, "textures/entity/standard_doll.png");

    public StandardDollRender(EntityRendererProvider.Context context) {
        super(context, new StandardDollModel<>(context.bakeLayer(StandardDollModel.LAYER_LOCATION)), 0.2F);
    }

    public ResourceLocation getTextureLocation(StandardDoll entity) {
        return TEX;
    }

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(LAYER_LOCATION, StandardDollModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(STANDARD_DOLL.get(), StandardDollRender::new);
    }

/*
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(DOLL.get(), context -> new MobRenderer<>(context, new DollModel<>(context.bakeLayer(LAYER_LOCATION)), 0.5F) {
            @Override
            public ResourceLocation getTextureLocation(Doll entity) {
                return new ResourceLocation(MODID, "textures/entity/standard_doll.png");
            }
        });
    }

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(LAYER_LOCATION, DollModel::createBodyLayer);
    }

 */

}
