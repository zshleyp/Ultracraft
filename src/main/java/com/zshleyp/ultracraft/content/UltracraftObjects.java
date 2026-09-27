package com.zshleyp.ultracraft.content;

import java.util.function.Supplier;

import com.zshleyp.ultracraft.Ultracraft;
//import com.zshleyp.ultracraft.content.block.*;
import com.zshleyp.ultracraft.content.block.entity.*;
import com.zshleyp.ultracraft.registry.UltracraftNeoforgeBlocks;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class UltracraftObjects {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
        DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Ultracraft.MODID);

    public static final Supplier<BlockEntityType<BloodTankEntity>> BLOOD_TANK_ENTITY = BLOCK_ENTITY_TYPES.register(
        "blood_tank_entity",
        () -> BlockEntityType.Builder.of(
            BloodTankEntity::new,
            UltracraftNeoforgeBlocks.BLOOD_TANK_BLOCK.get()
    )
    .build(null));
}
