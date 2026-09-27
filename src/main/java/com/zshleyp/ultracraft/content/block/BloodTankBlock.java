package com.zshleyp.ultracraft.content.block;

import com.mojang.serialization.MapCodec;
import com.zshleyp.ultracraft.content.block.entity.BloodTankEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class BloodTankBlock extends Block implements EntityBlock {
    public BloodTankBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BloodTankEntity(pos, state);
    }
}
