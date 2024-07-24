package top.chinuomlo.pixelmaiden;

import com.mojang.datafixers.DSL;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.chinuomlo.pixelmaiden.block.DollShelf;
import top.chinuomlo.pixelmaiden.block.DollShelfEntity;
import top.chinuomlo.pixelmaiden.entity.std_doll.StandardDoll;
import top.chinuomlo.pixelmaiden.item.DollSpawnClockwork;
import top.chinuomlo.pixelmaiden.item.GrimoireBook;

import static top.chinuomlo.pixelmaiden.PixelMaiden.MODID;

public class Registies {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MODID);
    protected static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final RegistryObject<EntityType<StandardDoll>> STANDARD_DOLL = ENTITY_TYPES.register("standard_doll", () -> EntityType.Builder.of(StandardDoll::new, MobCategory.CREATURE).sized(0.3F, 0.3F).build(new ResourceLocation(MODID, "standard_doll").toString()));

    public static final RegistryObject<Block> doll_shelf = BLOCKS.register("doll_shelf", () -> new DollShelf(BlockBehaviour.Properties.of().strength(3.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<BlockEntityType<DollShelfEntity>> doll_shelf_entity = BLOCK_ENTITY_TYPES.register("doll_shelf", () -> BlockEntityType.Builder.of(DollShelfEntity::new, doll_shelf.get()).build(DSL.remainderType()));

    public static final RegistryObject<Item> doll_shelf_item = ITEMS.register("doll_shelf", () -> new BlockItem(doll_shelf.get(), new Item.Properties()));
    public static final RegistryObject<Item> grimoire_book = ITEMS.register("grimoire_book", () -> new GrimoireBook(new Item.Properties()));
    public static final RegistryObject<Item> doll_spawn_clockwork = ITEMS.register("doll_spawn_clockwork", () -> new DollSpawnClockwork(new Item.Properties()));

    public static final RegistryObject<CreativeModeTab> mytab = CREATIVE_MODE_TABS.register("mytab", () -> CreativeModeTab.builder()
            .title(Component.translatable("mytabname"))
            .icon(() -> new ItemStack(grimoire_book.get()))
            .displayItems((parm, output) -> {
                output.accept(doll_shelf_item.get());
                output.accept(grimoire_book.get());
                output.accept(doll_spawn_clockwork.get());
            })
            .build());

}
