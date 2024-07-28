package top.chinuomlo.pixelmaiden.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import static top.chinuomlo.pixelmaiden.Registies.doll_shelf_entity;

public class DollShelfEntity extends BlockEntity {

    private static final int MAX_DOLL_COUNT = 4;

    public DollShelfEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    public DollShelfEntity(BlockPos worldPosition, BlockState blockState) {
        this(doll_shelf_entity.get(), worldPosition, blockState);
    }

    private final ItemStackHandler dolls = new ItemStackHandler(4){
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Block.UPDATE_ALL);
        }
    };

    private static final String TAG_NAME = "Doll";
    private final LazyOptional<IItemHandler> itemHandler = LazyOptional.of(() -> dolls);

    public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return itemHandler.cast();
        } else {
            return super.getCapability(cap, side);
        }
    }

    private void savedata(CompoundTag tag) {
        tag.put(TAG_NAME, dolls.serializeNBT());
    }

    private void loaddata(CompoundTag tag) {
        if (tag.contains(TAG_NAME)) {
            dolls.deserializeNBT(tag.getCompound(TAG_NAME));
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        savedata(tag);
    }
    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        loaddata(tag);
    }
    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = super.getUpdateTag();
        savedata(tag);
        return tag;
    }
    @Override
    public void handleUpdateTag(CompoundTag tag) {
        if (tag != null) {
            loaddata(tag);
        }
    }
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
    @Override
    public void onDataPacket(Connection connection, ClientboundBlockEntityDataPacket packet) {
        CompoundTag tag = packet.getTag();
        if (tag != null) {
            handleUpdateTag(tag);
        }
    }

    public void servertick() {

    }
    public void clienttick() {

    }


}
