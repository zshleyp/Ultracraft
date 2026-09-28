package com.zshleyp.ultracraft;

import java.util.function.Consumer;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.gameevent.BlockPositionSource;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.gameevent.GameEventListener;
import net.minecraft.world.level.gameevent.PositionSource;
import net.minecraft.world.phys.Vec3;

public class DeathListener implements GameEventListener {
    private final PositionSource position;
    public Consumer<Vec3> callback;
    private final int radius;

    public DeathListener(BlockPos pos, int radius, Consumer<Vec3> callback) {
        this.position = new BlockPositionSource(pos);
        this.callback = callback;
        this.radius = radius;
    }

    @Override
    public int getListenerRadius() {
        return this.radius;
    }

    @Override
    public PositionSource getListenerSource() {
        return position;
    }

    @Override
    public DeliveryMode getDeliveryMode() {
        return DeliveryMode.BY_DISTANCE;
    }

    @Override
    public boolean handleGameEvent(ServerLevel level, Holder<GameEvent> event, GameEvent.Context emitter, Vec3 emitterPos) {
        if(event.is(GameEvent.ENTITY_DIE.key()) && emitter.sourceEntity() instanceof LivingEntity) {
            this.callback.accept(emitterPos);
            return true;
        }
        return false;
    }
}
