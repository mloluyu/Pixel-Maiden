package top.chinuomlo.pixelmaiden;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import top.chinuomlo.pixelmaiden.block.DollShelfEntityRenderer;
import top.chinuomlo.pixelmaiden.entity.std_doll.StandardDoll;

import static top.chinuomlo.pixelmaiden.Registies.*;


@Mod(PixelMaiden.MODID)
public class PixelMaiden {
    public static final String MODID = "pixel_maiden";
    private static final Logger LOGGER = LogUtils.getLogger();

    public PixelMaiden() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        ENTITY_TYPES.register(modEventBus);
        BLOCK_ENTITY_TYPES.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus);

        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::registerAttributes);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @OnlyIn(Dist.CLIENT)
    private void setup(final FMLCommonSetupEvent event) {
    }

    private void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(STANDARD_DOLL.get(), StandardDoll.createAttributes().build());
    }

}


