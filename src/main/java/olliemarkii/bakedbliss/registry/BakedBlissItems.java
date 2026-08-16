package olliemarkii.bakedbliss.registry;

import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;

//? if >=26.1 {
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
 //? } else {
/*import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
 *///? }
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
//? if <=1.21.1 {
/*import net.minecraft.world.item.ItemNameBlockItem;
*///? }
import net.minecraft.world.level.block.Block;
import olliemarkii.bakedbliss.BakedBliss;
import olliemarkii.bakedbliss.item.BakedBlissFoodComponents;
import olliemarkii.bakedbliss.item.custom.SmokedBerryJamCookieItem;

import java.util.function.Function;

public class BakedBlissItems {
    public static final Item BERRY_JAM = register("berry_jam", Item::new, new Item.Properties());

    public static final Item BERRY_JAM_COOKIE = register(
            "berry_jam_cookie",
            Item::new,
            new Item.Properties()
                    .food(BakedBlissFoodComponents.BERRY_JAM_COOKIE
                            //? if >1.21.1 {
                            , BakedBlissFoodComponents.BERRY_JAM_COOKIE_CONSUMABLE
                            //? }
                    ));

    public static final Item SMOKED_BERRY_JAM = register(
            "smoked_berry_jam",
            Item::new,
            new Item.Properties());

    public static final Item SMOKED_BERRY_JAM_COOKIE = register(
            "smoked_berry_jam_cookie",
            SmokedBerryJamCookieItem::new,
            new Item.Properties().food(BakedBlissFoodComponents.SMOKED_BERRY_JAM_COOKIE
                    //? if >1.21.1 {
                        , BakedBlissFoodComponents.SMOKED_BERRY_JAM_COOKIE_CONSUMABLE
                    //? }
            ));

    public static final Item STRAWBERRY = register("strawberry",
            createBlockItemWithCustomItemName(BakedBlissBlocks.STRAWBERRY_CROP),
            new Item.Properties()
                    .food(BakedBlissFoodComponents.STRAWBERRY
                            //? if >1.21.1 {
                            , BakedBlissFoodComponents.STRAWBERRY_CONSUMABLE
                            //? }
                    ));

    public static final Item STRAWBERRY_PIE = register(
            "strawberry_pie",
            Item::new,
            new Item.Properties()
                    .food(BakedBlissFoodComponents.STRAWBERRY_PIE));

    public static final Item STRAWBERRY_SUNDAE = register(
            "strawberry_sundae", Item::new,
            new Item.Properties()
                    .food(BakedBlissFoodComponents.STRAWBERRY_SUNDAE
                            //? if >1.21.1 {
                            , BakedBlissFoodComponents.STRAWBERRY_SUNDAE_CONSUMABLE
                            //? }
                    ));

    public static final Item NYXBERRIES = register("nyxberries",
            createBlockItemWithCustomItemName(BakedBlissBlocks.NYXBERRY_BUSH),
            new Item.Properties());

    public static final Item DRIED_NYXBERRIES = register("dried_nyxberries",
            Item::new,
            new Item.Properties()
                    .food(BakedBlissFoodComponents.DRIED_NYXBERRIES
                            //? if >1.21.1 {
                            , BakedBlissFoodComponents.DRIED_NYXBERRIES_CONSUMABLE
                            //? }
                    ));

    public static final Item CANDIED_DRIED_NYXBERRIES = register(
            "candied_dried_nyxberries",
            Item::new,
            new Item.Properties()
                    .food(BakedBlissFoodComponents.CANDIED_DRIED_NYXBERRIES
                            //? if >1.21.1 {
                            , BakedBlissFoodComponents.CANDIED_DRIED_NYXBERRIES_CONSUMABLE
                            //? }
                    ));

    public static final Item NYXBERRY_JAM = register(
            "nyxberry_jam",
            Item::new,
            new Item.Properties());

    public static final Item NYXBERRY_SWIRL_CHEESECAKE = register(
            "nyxberry_swirl_cheesecake",
            Item::new,
            new Item.Properties()
                    .food(BakedBlissFoodComponents.NYXBERRY_SWIRL_CHEESECAKE));


    private static Function<Item.Properties, Item> createBlockItemWithCustomItemName(Block block) {
        //? if >=1.21.4 {
        return (properties) -> new BlockItem(block, properties
                .useItemDescriptionPrefix()
        );
        //? } else {
        /*return (properties) -> new ItemNameBlockItem(block, properties
        );
        *///? }
    }
    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, BakedBliss.of(name));

        T item = itemFactory.apply(settings
                        //? if >=1.21.4 {
                        .setId(itemKey)
                //? }
        );

        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static void registerModItems() {
        BakedBliss.LOGGER.info("Registering Baked Bliss Items for " + BakedBliss.MOD_ID);


        //? if >=26.1 {
        
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS)
        //? } else {
        /*ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS)
        *///? }
        .register((creativeTab) -> {
            creativeTab.accept(BERRY_JAM);
        });
    }
}
