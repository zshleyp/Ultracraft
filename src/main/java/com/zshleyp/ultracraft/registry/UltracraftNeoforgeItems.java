package com.zshleyp.ultracraft.registry;

import com.zshleyp.ultracraft.Ultracraft;
import com.zshleyp.ultracraft.content.item.*;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class UltracraftNeoforgeItems {
    static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Ultracraft.MODID);

    public static final DeferredItem<Item> BOTTLE_OF_BLOOD = ITEMS.register("bottle_of_blood",
        () -> new BottleOfBlood(new Item.Properties()
            .stacksTo(16)
            .food(new FoodProperties.Builder()
                .nutrition(-2)
                .saturationModifier(-5.0f)
                .alwaysEdible()
                .build())
        ));

    public static final DeferredItem<BlockItem> BLOOD_TANK_ITEM = ITEMS.register("blood_tank",
        () -> new BloodTankItem(UltracraftNeoforgeBlocks.BLOOD_TANK_BLOCK.get(), new Item.Properties()
            .stacksTo(1)
        )
    );

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
