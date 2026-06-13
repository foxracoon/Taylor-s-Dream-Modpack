package noelle.taylor.world;

import net.fabricmc.fabric.api.biome.v1.BiomeModification;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.OrePlacedFeatures;

public class ModOreGeneration {

    public static void generateOres() {

        BiomeModifications.create(
                        Identifier.of("taylors-dream-modpack", "nether_gold_ore"))
                .add(
                        ModificationPhase.REPLACEMENTS,
                        BiomeSelectors.foundInTheNether(),
                        (selection, context) -> {

                            context.getGenerationSettings().removeFeature(
                                    GenerationStep.Feature.UNDERGROUND_ORES,
                                    OrePlacedFeatures.ORE_GOLD_NETHER
                            );

                            context.getGenerationSettings().addFeature(
                                    GenerationStep.Feature.UNDERGROUND_ORES,
                                    ModPlacedFeatures.NETHER_GOLD_ORE_PLACED
                            );
                        }
                );
    }
}
