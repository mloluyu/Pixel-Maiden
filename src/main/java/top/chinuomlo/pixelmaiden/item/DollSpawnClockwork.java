package top.chinuomlo.pixelmaiden.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import top.chinuomlo.pixelmaiden.Registies;
import top.chinuomlo.pixelmaiden.entity.std_doll.StandardDoll;

/**
 * 2024-7-8
 * @author mloluyu
 * 该类已完善
 */

public class DollSpawnClockwork extends Item {
    public DollSpawnClockwork(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        if (!world.isClientSide) {
            BlockPos pos = context.getClickedPos().relative(context.getClickedFace());
            ItemStack itemstack = context.getItemInHand();
            Player player = context.getPlayer();
            if (player != null && player.mayUseItemAt(pos, context.getClickedFace(), itemstack)) {
                // 生成生物实体
                StandardDoll standardDoll = new StandardDoll(Registies.STANDARD_DOLL.get(), world);
                standardDoll.moveTo(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, world.getRandom().nextFloat() * 360.0F, 0.0F);
                world.addFreshEntity(standardDoll);

                if (!player.getAbilities().instabuild) {
                    itemstack.shrink(1);
                }
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }
}
