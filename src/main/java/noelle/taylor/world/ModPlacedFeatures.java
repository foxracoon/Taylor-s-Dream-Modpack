package noelle.taylor.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import noelle.taylor.TaylorSDreamModpack;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> NETHER_GOLD_ORE_PLACED =
            RegistryKey.of(
                    RegistryKeys.PLACED_FEATURE,
                    Identifier.of(TaylorSDreamModpack.MOD_ID, "nehter_gold_ore")
            );

    public static void bootstrap(Registerable<PlacedFeature> context) {

        var lookup =
                context.getRegistryLookup(
                        RegistryKeys.CONFIGURED_FEATURE
                );

        context.register(
                NETHER_GOLD_ORE_PLACED,
                new PlacedFeature(
                        lookup.getOrThrow(
                                ModConfiguredFeatures.NETHER_GOLD_ORE
                        ),
                        List.of(
                                CountPlacementModifier.of(18),
                                SquarePlacementModifier.of(),
                                HeightRangePlacementModifier.uniform(
                                        YOffset.getBottom(),
                                        YOffset.fixed(128)
                                ),
                                BiomePlacementModifier.of()
                        )
                )
        );
    }
}