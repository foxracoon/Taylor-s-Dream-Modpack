package noelle.taylor.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import noelle.taylor.TaylorSDreamModpack;

public class ModBlocks {
    public static final Block NETHER_GOLD_ORE = registerBlock("nether_gold_ore",
            new Block(AbstractBlock.Settings.create().strength(3.5f)
                    .requiresTool()));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TaylorSDreamModpack.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TaylorSDreamModpack.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TaylorSDreamModpack.LOGGER.info("Registering Mod Blocks for " + TaylorSDreamModpack.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(ModBlocks.NETHER_GOLD_ORE);
        });
    }
}
