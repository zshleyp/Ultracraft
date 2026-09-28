package com.zshleyp.ultracraft.content.block.entity;

import java.util.function.Consumer;

import org.jetbrains.annotations.Nullable;

import com.zshleyp.ultracraft.DeathListener;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.phys.Vec3;

public class BloodCollectorEntity extends BlockEntity implements GameEventListener.Provider<DeathListener> {
    public @Nullable DeathListener deathListener;

    public BloodCollectorEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public DeathListener getListener() {
        return this.deathListener;
    }
}
