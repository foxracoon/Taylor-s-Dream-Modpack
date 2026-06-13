package noelle.taylor.Item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import noelle.taylor.TaylorSDreamModpack;

public class ModItems {

    //jade stuff idk if more will be added
    public static Item JADE_SPEAR_HEAD = registerItem("jade_spear_head",
            new Item(new Item.Settings().maxCount(1)));

    //nether gold
    public static Item NETHER_GOLD_NUGGET = registerItem("nether_gold_nugget",
            new Item(new Item.Settings().maxCount(1)));



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TaylorSDreamModpack.MOD_ID, name),item);
    }

    public static void registerModItems() {
        TaylorSDreamModpack.LOGGER.info("Registering Mod Items for" + TaylorSDreamModpack.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(JADE_SPEAR_HEAD);

            ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries1 ->
                    fabricItemGroupEntries.add(NETHER_GOLD_NUGGET));
        });
    }
}
