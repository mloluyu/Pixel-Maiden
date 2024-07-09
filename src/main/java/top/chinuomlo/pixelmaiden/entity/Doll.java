package top.chinuomlo.pixelmaiden.entity;

import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.npc.InventoryCarrier;
import net.minecraft.world.level.Level;

public class Doll extends PathfinderMob implements InventoryCarrier {

    private final SimpleContainer inventory = new SimpleContainer(5);//创建物品栏
    //private final

    public Doll(EntityType<? extends Doll> entity, Level level) {
        super(entity, level);
        this.moveControl = new FlyingMoveControl(this, 20, true);
        this.setCanPickUpLoot(this.canPickUpLoot());

    }

    /*测试数据待修改*/
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.7D)
                .add(Attributes.FLYING_SPEED, 0.7D);
    }

    public SimpleContainer getInventory() {
        return this.inventory;
    }

    protected void registerGoals() {
        
    }
}