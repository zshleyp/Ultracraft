package com.zshleyp.ultracraft.content.block.entity;

import com.zshleyp.ultracraft.DeathListener;
import com.zshleyp.ultracraft.Ultracraft;
import com.zshleyp.ultracraft.content.UltracraftObjects;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.state.BlockState;

public class BloodTankEntity extends BloodCollectorEntity {
    public static final double MAX_BLOOD_OZ = 32;
    public double blood_oz;

    public BloodTankEntity(BlockPos pos, BlockState state) {
        super(UltracraftObjects.BLOOD_TANK_ENTITY.get(), pos, state);

        //8 is radius
        this.deathListener = new DeathListener(pos, 8, (deathPos) -> {
            this.blood_oz = Math.min(this.blood_oz + 0.25, MAX_BLOOD_OZ);
            this.setChanged();
            Ultracraft.LOGGER.info("entity died near the blood tank! blood_oz: {}", this.blood_oz);
        });
    }

    @Override
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        this.blood_oz = tag.getDouble("ultracraft.blood_oz");
    }

    @Override
    public void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        tag.putDouble("ultracraft.blood_oz", this.blood_oz);
        //Run this.setChanged() in order to actually save this state!
    }
}
