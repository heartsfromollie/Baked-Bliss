package heartsfromollie.bakedbliss.items;

import heartsfromollie.bakedbliss.BakedBliss;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup BB_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(BakedBliss.MOD_ID, "bb"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.BERRY_JAM_COOKIE))
                    .displayName(Text.translatable("itemgroup.baked_bliss.bb")
                            .withColor(0xB65C27))
                    .entries((displayContext, entries) -> {



                        entries.add(Items.COCOA_BEANS);
                        entries.add(ModItems.COCOA_POWDER);
                        entries.add(ModItems.WHITE_COCOA_BEANS);
                        entries.add(ModItems.WHITE_COCOA_POWDER);
                        entries.add(ModItems.WHITE_CHOCOLATE_COOKIE);
                        entries.add(Items.SWEET_BERRIES);
                        entries.add(ModItems.BERRY_JAM);
                        entries.add(ModItems.BERRY_JAM_COOKIE);
                        entries.add(ModItems.PUMPKIN_BREAD);
                        entries.add(ModItems.PUMPKIN_SLICE);


                    }).build());




    public static void registerItemGroups() {
        BakedBliss.LOGGER.info("Registering Item Groups for" + BakedBliss.MOD_ID);
    }
}
