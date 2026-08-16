package olliemarkii.bakedbliss.registry;

import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import olliemarkii.bakedbliss.BakedBliss;
import olliemarkii.bakedbliss.item.BakedBlissFoodComponents;
import olliemarkii.bakedbliss.item.custom.SmokedBerryJamCookieItem;

public class BakedBlissItems {
    public static final Item BERRY_JAM = registerItem("berry_jam", new Item(new Item.Properties()));

    public static final Item BERRY_JAM_COOKIE = registerItem("berry_jam_cookie", new Item(new Item.Properties()
            .food(BakedBlissFoodComponents.BERRY_JAM_COOKIE)));

    public static final Item SMOKED_BERRY_JAM = registerItem("smoked_berry_jam", new Item(new Item.Properties()));

    public static final Item SMOKED_BERRY_JAM_COOKIE = registerItem("smoked_berry_jam_cookie",

            new SmokedBerryJamCookieItem(new Item.Properties().food(BakedBlissFoodComponents.SMOKED_BERRY_JAM_COOKIE)));

    public static final Item STRAWBERRY = registerItem("strawberry",
        new ItemNameBlockItem(BakedBlissBlocks.STRAWBERRY_CROP, new Item.Properties()
                .food(BakedBlissFoodComponents.STRAWBERRY)));

    public static final Item STRAWBERRY_PIE = registerItem("strawberry_pie", new Item(new Item.Properties()
            .food(BakedBlissFoodComponents.STRAWBERRY_PIE)));

    public static final Item STRAWBERRY_SUNDAE = registerItem("strawberry_sundae", new Item(new Item.Properties()
            .food(BakedBlissFoodComponents.STRAWBERRY_SUNDAE)));

    public static final Item NYXBERRIES = registerItem("nyxberries",
            new ItemNameBlockItem(BakedBlissBlocks.NYXBERRY_BUSH, new Item.Properties()));

    public static final Item DRIED_NYXBERRIES = registerItem("dried_nyxberries",
            new Item(new Item.Properties()
                    .food(BakedBlissFoodComponents.DRIED_NYXBERRIES)));

    public static final Item CANDIED_DRIED_NYXBERRIES = registerItem("candied_dried_nyxberries",
            new Item(new Item.Properties()
                    .food(BakedBlissFoodComponents.CANDIED_DRIED_NYXBERRIES)));

    public static final Item NYXBERRY_JAM = registerItem("nyxberry_jam", new Item(new Item.Properties()));

    public static final Item NYXBERRY_SWIRL_CHEESECAKE = registerItem("nyxberry_swirl_cheesecake",
            new Item(new Item.Properties()
                    .food(BakedBlissFoodComponents.NYXBERRY_SWIRL_CHEESECAKE)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(BakedBliss.MOD_ID, name), item);
    }


    public static void registerModItems() {
        BakedBliss.LOGGER.info("Registering Baked Bliss Items for " + BakedBliss.MOD_ID);


        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(entries -> {
            entries.accept(BERRY_JAM);
        });
    }
}
