package top.chinuomlo.pixelmaiden;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.chinuomlo.pixelmaiden.entity.Doll;
import top.chinuomlo.pixelmaiden.item.GrimoireBook;

import static top.chinuomlo.pixelmaiden.PixelMaiden.MODID;

public class Registies {
    protected static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    protected static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    protected static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);
    protected static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<EntityType<Doll>> DOLL = ENTITY_TYPES.register("doll", () -> EntityType.Builder.of(Doll::new, MobCategory.CREATURE).sized(0.3F, 0.3F).build(new ResourceLocation(MODID, "doll").toString()));

    public static final RegistryObject<Item> grimoire_book = ITEMS.register("grimoire_book", () -> new GrimoireBook(new Item.Properties()));

    public static final RegistryObject<CreativeModeTab> mytab = CREATIVE_MODE_TABS.register("mytab", () -> CreativeModeTab.builder()
            .title(Component.translatable("mytabname"))
            .icon(() -> new ItemStack(grimoire_book.get()))
            .displayItems((parm, output) -> {
                //output.accept(myblockitem.get());
                output.accept(grimoire_book.get());
            })
            .build());
}
