package top.chinuomlo.pixelmaiden.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;

public class GrimoireBook extends Item {

    public GrimoireBook(Item.Properties properties) {
        super(properties.stacksTo(1));
    }

}
