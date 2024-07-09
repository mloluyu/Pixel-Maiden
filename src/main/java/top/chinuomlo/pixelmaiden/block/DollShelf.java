package top.chinuomlo.pixelmaiden.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DollShelf extends BaseEntityBlock {
    /*
    public static final BooleanProperty DOLLSHELF_SLOT_0_OCCUPIED = BooleanProperty.create("slot_0_occupied");
    public static final BooleanProperty DOLLSHELF_SLOT_1_OCCUPIED = BooleanProperty.create("slot_1_occupied");
    public static final BooleanProperty DOLLSHELF_SLOT_2_OCCUPIED = BooleanProperty.create("slot_2_occupied");
    public static final BooleanProperty DOLLSHELF_SLOT_3_OCCUPIED = BooleanProperty.create("slot_3_occupied");
    public static final BooleanProperty DOLLSHELF_SLOT_4_OCCUPIED = BooleanProperty.create("slot_4_occupied");
    public static final BooleanProperty DOLLSHELF_SLOT_5_OCCUPIED = BooleanProperty.create("slot_5_occupied");
    public static final BooleanProperty DOLLSHELF_SLOT_6_OCCUPIED = BooleanProperty.create("slot_6_occupied");
    public static final BooleanProperty DOLLSHELF_SLOT_7_OCCUPIED = BooleanProperty.create("slot_7_occupied");


     */
    private static final int MAX_DOLL_COUNT = 8;
    public static final int DOLLS_PER_ROW = 4;
    //public static final List<BooleanProperty> SLOT_OCCUPIED_PROPERTIES = List.of(DOLLSHELF_SLOT_0_OCCUPIED, DOLLSHELF_SLOT_1_OCCUPIED, DOLLSHELF_SLOT_2_OCCUPIED, DOLLSHELF_SLOT_3_OCCUPIED, DOLLSHELF_SLOT_4_OCCUPIED, DOLLSHELF_SLOT_5_OCCUPIED, DOLLSHELF_SLOT_6_OCCUPIED, DOLLSHELF_SLOT_7_OCCUPIED);

    public DollShelf(BlockBehaviour.Properties properties) {
        super(properties);
        /*
        BlockState blockState = this.stateDefinition.any().setValue(HorizontalDirectionalBlock.FACING, Direction.NORTH);

        for (BooleanProperty property : SLOT_OCCUPIED_PROPERTIES) {
            blockState = blockState.setValue(property, Boolean.valueOf(false));
        }

        this.registerDefaultState(blockState);
        
         */
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return null;
    }


}
