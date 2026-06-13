package noelle.taylor.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import noelle.taylor.TaylorSDreamModpack;
import noelle.taylor.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_GOLD_ORE =
            RegistryKey.of(
                    RegistryKeys.CONFIGURED_FEATURE,
                    Identifier.of(TaylorSDreamModpack.MOD_ID, "nehter_gold_ore")
            );
    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        RuleTest netherrack =
                new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);

        List<OreFeatureConfig.Target> targets = List.of(
                OreFeatureConfig.createTarget(
                        netherrack,
                        ModBlocks.NETHER_GOLD_ORE.getDefaultState()
                )
        );
        context.register(
                NETHER_GOLD_ORE,
                new ConfiguredFeature<>(
                        Feature.ORE,
                        new OreFeatureConfig(targets, 4)
                )
        );
    }
}
