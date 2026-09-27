package com.zshleyp.ultracraft.content.block.entity;

import com.zshleyp.ultracraft.content.UltracraftObjects;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class BloodTankEntity extends BlockEntity {
    private byte blood_oz;
    public BloodTankEntity(BlockPos pos, BlockState state) {
        super(UltracraftObjects.BLOOD_TANK_ENTITY.get(), pos, state);
    }

    @Override
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.blood_oz = tag.getByte("blood_oz");
    }

    @Override
    public void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putByte("blood_oz", this.blood_oz);
        //Run this.setChanged() in order to actually save this state!
    }
}
