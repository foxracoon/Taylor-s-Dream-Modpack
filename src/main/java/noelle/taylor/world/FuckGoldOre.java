package noelle.taylor.world;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class FuckGoldOre implements ModInitializer {

    private static final RegistryKey<PlacedFeature> NETHER_GOLD_ORE =
            RegistryKey.of(
                    RegistryKeys.PLACED_FEATURE,
                    Identifier.of("minecraft", "ore_gold_nether")
            );

    @Override
    public void onInitialize() {

        BiomeModifications.create(
                Identifier.of("taylors-dream-modpack", "remove_nether_gold_ore")
        ).add(
                ModificationPhase.REMOVALS,
                BiomeSelectors.foundInTheNether(),
                (selectionContext, modificationContext) -> {
                    modificationContext.getGenerationSettings().removeFeature(
                            GenerationStep.Feature.UNDERGROUND_ORES,
                            NETHER_GOLD_ORE
                    );
                }
        );
    }
}