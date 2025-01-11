package heartsfromollie.bakedbliss.items;

import heartsfromollie.bakedbliss.BakedBliss;
import heartsfromollie.bakedbliss.food.ModFoodComponents;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item COCOA_POWDER = registerItem("cocoa_powder", new Item(new Item.Settings()));
    public static final Item WHITE_COCOA_POWDER = registerItem("white_cocoa_powder", new Item(new Item.Settings()));
    public static final Item WHITE_COCOA_BEANS = registerItem("white_cocoa_beans", new Item(new Item.Settings()));
    public static final Item WHITE_CHOCOLATE_COOKIE = registerItem("white_chocolate_cookie", new Item(new Item.Settings()
            .food(ModFoodComponents.WHITE_CHOCOLATE_COOKIE)));
    public static final Item BERRY_JAM = registerItem("berry_jam", new Item(new Item.Settings()));
    public static final Item BERRY_JAM_COOKIE = registerItem("berry_jam_cookie", new Item(new Item.Settings()
            .food(ModFoodComponents.BERRY_JAM_COOKIE)));
    public static final Item PUMPKIN_BREAD = registerItem("pumpkin_bread", new Item(new Item.Settings()
            .food(ModFoodComponents.PUMPKIN_BREAD)));
    public static final Item PUMPKIN_SLICE = registerItem("pumpkin_slice", new Item(new Item.Settings()
            .food(ModFoodComponents.PUMPKIN_SLICE)));





    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BakedBliss.MOD_ID, name), item);
    }

    public static void registerModItems() {
        BakedBliss.LOGGER.info("Registering Mod Items for" + BakedBliss.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(COCOA_POWDER);
            fabricItemGroupEntries.add(WHITE_COCOA_POWDER);
            fabricItemGroupEntries.add(WHITE_COCOA_BEANS);
            fabricItemGroupEntries.add(BERRY_JAM);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(fabricItemGroupEntries -> {;
            fabricItemGroupEntries.add(WHITE_COCOA_BEANS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(WHITE_CHOCOLATE_COOKIE);
            fabricItemGroupEntries.add(BERRY_JAM_COOKIE);
            fabricItemGroupEntries.add(PUMPKIN_BREAD);
            fabricItemGroupEntries.add(PUMPKIN_SLICE);
        });
    }
}
