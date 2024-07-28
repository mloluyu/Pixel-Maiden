package top.chinuomlo.pixelmaiden.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.jetbrains.annotations.Nullable;

public class DollShelf extends BaseEntityBlock {
    public static final DirectionProperty FACING = DirectionProperty.create("facing", Direction.Plane.HORIZONTAL);

    /*
    public static final BooleanProperty DOLLSHELF_SLOT_0_OCCUPIED = BooleanProperty.create("slot_0_occupied");
    public static final BooleanProperty DOLLSHELF_SLOT_1_OCCUPIED = BooleanProperty.create("slot_1_occupied");
    public static final BooleanProperty DOLLSHELF_SLOT_2_OCCUPIED = BooleanProperty.create("slot_2_occupied");
    public static final BooleanProperty DOLLSHELF_SLOT_3_OCCUPIED = BooleanProperty.create("slot_3_occupied");
     */

    private static boolean empty;
    public static final int MAX_DOLL_COUNT = 4;
    public static final int DOLLS_PER_ROW = 2;
    //public static final List<BooleanProperty> SLOT_OCCUPIED_PROPERTIES = List.of(DOLLSHELF_SLOT_0_OCCUPIED, DOLLSHELF_SLOT_1_OCCUPIED, DOLLSHELF_SLOT_2_OCCUPIED, DOLLSHELF_SLOT_3_OCCUPIED, DOLLSHELF_SLOT_4_OCCUPIED, DOLLSHELF_SLOT_5_OCCUPIED, DOLLSHELF_SLOT_6_OCCUPIED, DOLLSHELF_SLOT_7_OCCUPIED);

    public DollShelf(Properties properties) {
        super(properties);
        /*
        BlockState blockState = this.stateDefinition.any().setValue(HorizontalDirectionalBlock.FACING, Direction.NORTH);

        for (BooleanProperty property : SLOT_OCCUPIED_PROPERTIES) {
            blockState = blockState.setValue(property, Boolean.valueOf(false));
        }

        this.registerDefaultState(blockState);
        
         */
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    /*
    @Override
    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }
     */
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new DollShelfEntity(blockPos, blockState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pBlockState, BlockEntityType<T> tBlockEntityType) {
        if (pLevel.isClientSide()) {
            return (level, pos, state, blockentity) -> {
                if (blockentity instanceof DollShelfEntity be) {
                    be.clienttick();
                }
            };
        } else {
            return (level, pos, state, blockentity) -> {
                if (blockentity instanceof DollShelfEntity be) {
                    be.servertick();
                }
            };
        }
    }



}
