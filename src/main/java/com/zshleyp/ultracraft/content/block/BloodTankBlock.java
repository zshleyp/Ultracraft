package com.zshleyp.ultracraft.content.block;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.mojang.serialization.MapCodec;
import com.zshleyp.ultracraft.Ultracraft;
import com.zshleyp.ultracraft.content.block.entity.BloodTankEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

public class BloodTankBlock extends Block implements EntityBlock {
    public BloodTankBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    protected @NotNull List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
        List<ItemStack> droppedStacks = super.getDrops(state, builder);

        BlockEntity blockEntity = builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if(blockEntity instanceof BloodTankEntity bloodTankEntity) {
            for(ItemStack stack : droppedStacks) {
                CustomData.update(DataComponents.CUSTOM_DATA, stack, tag -> {
                    tag.putDouble("ultracraft.blood_oz", bloodTankEntity.blood_oz);
                });
            }
        }

        return droppedStacks;
    }

    @Override
    public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(world, pos, state, placer, stack);

        CustomData data = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY);

        if(world.getBlockEntity(pos) instanceof BloodTankEntity bloodTankEntity) {
            bloodTankEntity.blood_oz = data.copyTag().getDouble("ultracraft.blood_oz");
            bloodTankEntity.setChanged();
        }
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new BloodTankEntity(pos, state);
    }
}
