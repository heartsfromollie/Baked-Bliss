package olliemarkii.bakedbliss.item;

//? if >=26.1 {
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
//? } else {
/*import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
*///? }
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import olliemarkii.bakedbliss.BakedBliss;
import olliemarkii.bakedbliss.registry.BakedBlissItems;

public class BakedBlissItemGroups {
    public static final CreativeModeTab BAKED_BLISS_ITEM_GROUP = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
            BakedBliss.of("bb_items"),
            //? if >=26.1 {
            FabricCreativeModeTab
            //? } else {
            /*FabricItemGroup
            *///? }
                    .builder().icon(()-> new ItemStack(BakedBlissItems.STRAWBERRY))
                    .title(Component.translatable("itemgroup.bakedbliss.bb_items"))
                    .displayItems((displayContext, entries) -> {
                        entries.accept(BakedBlissItems.STRAWBERRY);
                        entries.accept(Items.SWEET_BERRIES);
                        entries.accept(BakedBlissItems.NYXBERRIES);
                        entries.accept(BakedBlissItems.BERRY_JAM);
                        entries.accept(BakedBlissItems.SMOKED_BERRY_JAM);
                        entries.accept(BakedBlissItems.BERRY_JAM_COOKIE);
                        entries.accept(BakedBlissItems.SMOKED_BERRY_JAM_COOKIE);
                        entries.accept(BakedBlissItems.STRAWBERRY_PIE);
                        entries.accept(BakedBlissItems.STRAWBERRY_SUNDAE);
                        entries.accept(BakedBlissItems.DRIED_NYXBERRIES);
                        entries.accept(BakedBlissItems.CANDIED_DRIED_NYXBERRIES);
                        entries.accept(BakedBlissItems.NYXBERRY_JAM);
                        entries.accept(BakedBlissItems.NYXBERRY_SWIRL_CHEESECAKE);
                    }).build());
    public static void registerItemGroups() {
        BakedBliss.LOGGER.info("Registering Item Groups for " + BakedBliss.MOD_ID);
    }
}
