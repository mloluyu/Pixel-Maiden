package top.chinuomlo.pixelmaiden.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import top.chinuomlo.pixelmaiden.PixelMaiden;

import static top.chinuomlo.pixelmaiden.PixelMaiden.MODID;
import static top.chinuomlo.pixelmaiden.Registies.DOLL;
import static top.chinuomlo.pixelmaiden.entity.DollModel.*;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class DollRender extends MobRenderer<Doll, DollModel<Doll>> {

    public static final ResourceLocation TEX = new ResourceLocation(MODID, "textures/entity/doll.png");

    public DollRender(EntityRendererProvider.Context context) {
        super(context, new DollModel<>(context.bakeLayer(DollModel.LAYER_LOCATION)), 0.2F);
    }

    public ResourceLocation getTextureLocation(Doll entity) {
        return TEX;
    }

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(LAYER_LOCATION, DollModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void onRegisterRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(DOLL.get(), DollRender::new);
    }

/*
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        EntityRenderers.register(DOLL.get(), context -> new MobRenderer<>(context, new DollModel<>(context.bakeLayer(LAYER_LOCATION)), 0.5F) {
            @Override
            public ResourceLocation getTextureLocation(Doll entity) {
                return new ResourceLocation(MODID, "textures/entity/doll.png");
            }
        });
    }

    @SubscribeEvent
    public static void onRegisterLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(LAYER_LOCATION, DollModel::createBodyLayer);
    }

 */

}
