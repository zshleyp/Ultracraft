package com.zshleyp.ultracraft.content.item;

import java.util.List;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.block.Block;

public class BloodTankItem extends BlockItem {
    public BloodTankItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        CustomData data = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY);
        tooltipComponents.add(Component.translatable("tooltip.ultracraft.blood_container", data.copyTag().getDouble("ultracraft.blood_oz")));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
