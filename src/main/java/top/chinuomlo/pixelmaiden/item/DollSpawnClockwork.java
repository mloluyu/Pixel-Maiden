package top.chinuomlo.pixelmaiden.item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import top.chinuomlo.pixelmaiden.Registies;
import top.chinuomlo.pixelmaiden.entity.Doll;

public class DollSpawnClockwork extends Item {
    public DollSpawnClockwork(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level world = context.getLevel();
        if (!world.isClientSide) {
            BlockPos position = context.getClickedPos().relative(context.getClickedFace());// 生成位置在点击的方块
            Player player = context.getPlayer();
            ItemStack itemStack = context.getItemInHand();

            Doll doll = new Doll(Registies.DOLL.get(), world);
            doll.moveTo(position.getX(), position.getY(), position.getZ(), player.getYRot(), player.getXRot());
            world.addFreshEntity(doll);

            if (!player.getAbilities().instabuild) {
                itemStack.shrink(1); // 使用后减少一个物品
            }

            return InteractionResult.SUCCESS;
        }

        return InteractionResult.FAIL;
    }
}
