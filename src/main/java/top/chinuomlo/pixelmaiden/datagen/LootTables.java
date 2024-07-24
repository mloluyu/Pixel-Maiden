package top.chinuomlo.pixelmaiden.datagen;

import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import top.chinuomlo.pixelmaiden.Registies;

public class LootTables extends VanillaBlockLoot {

    @Override
    public Iterable<Block> getKnownBlocks() {
        return Registies.BLOCKS.getEntries().stream().flatMap(RegistryObject::stream)::iterator;
    }

    public void generate() {
        dropSelf(Registies.doll_shelf.get());
    }
}
