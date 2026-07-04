package olliemarkii.bakedbliss.registry;

import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import olliemarkii.bakedbliss.BakedBliss;
import olliemarkii.bakedbliss.item.BakedBlissFoodComponents;
import olliemarkii.bakedbliss.item.custom.SmokedBerryJamCookieItem;

public class BakedBlissItems {
    public static final Item BERRY_JAM = registerItem("berry_jam", new Item(new Item.Settings()));

    public static final Item BERRY_JAM_COOKIE = registerItem("berry_jam_cookie", new Item(new Item.Settings()
            .food(BakedBlissFoodComponents.BERRY_JAM_COOKIE)));

    public static final Item SMOKED_BERRY_JAM = registerItem("smoked_berry_jam", new Item(new Item.Settings()));

    public static final Item SMOKED_BERRY_JAM_COOKIE = registerItem("smoked_berry_jam_cookie",

            new SmokedBerryJamCookieItem(new Item.Settings().food(BakedBlissFoodComponents.SMOKED_BERRY_JAM_COOKIE)));

    public static final Item STRAWBERRY = registerItem("strawberry",
        new AliasedBlockItem(BakedBlissBlocks.STRAWBERRY_CROP, new Item.Settings()
                .food(BakedBlissFoodComponents.STRAWBERRY)));

    public static final Item STRAWBERRY_PIE = registerItem("strawberry_pie", new Item(new Item.Settings()
            .food(BakedBlissFoodComponents.STRAWBERRY_PIE)));

    public static final Item STRAWBERRY_SUNDAE = registerItem("strawberry_sundae", new Item(new Item.Settings()
            .food(BakedBlissFoodComponents.STRAWBERRY_SUNDAE)));

    public static final Item NYXBERRIES = registerItem("nyxberries",
            new AliasedBlockItem(BakedBlissBlocks.NYXBERRY_BUSH, new Item.Settings()));

    public static final Item DRIED_NYXBERRIES = registerItem("dried_nyxberries",
            new Item(new Item.Settings()
                    .food(BakedBlissFoodComponents.DRIED_NYXBERRIES)));

    public static final Item CANDIED_DRIED_NYXBERRIES = registerItem("candied_dried_nyxberries",
            new Item(new Item.Settings()
                    .food(BakedBlissFoodComponents.CANDIED_DRIED_NYXBERRIES)));

    public static final Item NYXBERRY_JAM = registerItem("nyxberry_jam", new Item(new Item.Settings()));

    public static final Item NYXBERRY_SWIRL_CHEESECAKE = registerItem("nyxberry_swirl_cheesecake",
            new Item(new Item.Settings()
                    .food(BakedBlissFoodComponents.NYXBERRY_SWIRL_CHEESECAKE)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(BakedBliss.MOD_ID, name), item);
    }


    public static void registerModItems() {
        BakedBliss.LOGGER.info("Registering Baked Bliss Items for " + BakedBliss.MOD_ID);


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(BERRY_JAM);
        });
    }
}
