package com.zshleyp.ultracraft.registry;

import com.zshleyp.ultracraft.Ultracraft;
import com.zshleyp.ultracraft.content.block.BloodTankBlock;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class UltracraftNeoforgeBlocks {
    static final DeferredRegister.Blocks BLOCKS = DeferredRegister.Blocks.createBlocks(Ultracraft.MODID);
    public static final DeferredBlock<Block> BLOOD_TANK_BLOCK = BLOCKS.register("blood_tank",
        () -> new BloodTankBlock(
            BlockBehaviour.Properties.ofFullCopy(Blocks.COPPER_BLOCK).noLootTable()
        ));

    public static void register(IEventBus modEventBus) {
       BLOCKS.register(modEventBus);
    }
}
