package olliemarkii.bakedbliss.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import olliemarkii.bakedbliss.BakedBliss;
import olliemarkii.bakedbliss.registry.BakedBlissItems;

public class BakedBlissItemGroups {
    public static final ItemGroup BAKED_BLISS_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(BakedBliss.MOD_ID, "bb_items"),
            FabricItemGroup.builder().icon(()-> new ItemStack(BakedBlissItems.STRAWBERRY))
                    .displayName(Text.translatable("itemgroup.bakedbliss.bb_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(BakedBlissItems.STRAWBERRY);
                        entries.add(Items.SWEET_BERRIES);
                        entries.add(BakedBlissItems.NYXBERRIES);
                        entries.add(BakedBlissItems.BERRY_JAM);
                        entries.add(BakedBlissItems.SMOKED_BERRY_JAM);
                        entries.add(BakedBlissItems.BERRY_JAM_COOKIE);
                        entries.add(BakedBlissItems.SMOKED_BERRY_JAM_COOKIE);
                        entries.add(BakedBlissItems.STRAWBERRY_PIE);
                        entries.add(BakedBlissItems.STRAWBERRY_SUNDAE);
                        entries.add(BakedBlissItems.DRIED_NYXBERRIES);
                        entries.add(BakedBlissItems.CANDIED_DRIED_NYXBERRIES);
                        entries.add(BakedBlissItems.NYXBERRY_JAM);
                        entries.add(BakedBlissItems.NYXBERRY_SWIRL_CHEESECAKE);






                    }).build());
    public static void registerItemGroups() {
        BakedBliss.LOGGER.info("Registering Item Groups for " + BakedBliss.MOD_ID);
    }
}
