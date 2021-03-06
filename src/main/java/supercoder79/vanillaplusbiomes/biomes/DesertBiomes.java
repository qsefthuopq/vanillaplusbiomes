package supercoder79.vanillaplusbiomes.biomes;

import com.terraformersmc.terraform.biome.builder.TerraformBiome;
import net.fabricmc.fabric.api.biomes.v1.OverworldBiomes;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

import static com.terraformersmc.terraform.biome.builder.DefaultFeature.*;

public class DesertBiomes {
    public static final ConfiguredStructureFeature<StructurePoolFeatureConfig, ? extends StructureFeature<StructurePoolFeatureConfig>> VILLAGE_18 = StructureFeature.VILLAGE.configure(new StructurePoolFeatureConfig(new Identifier("village/desert/town_centers"), 18));
    public static final ConfiguredStructureFeature<StructurePoolFeatureConfig, ? extends StructureFeature<StructurePoolFeatureConfig>> VILLAGE_12 = StructureFeature.VILLAGE.configure(new StructurePoolFeatureConfig(new Identifier("village/desert/town_centers"), 12));

    @SuppressWarnings("unchecked")
    public static TerraformBiome.Template template = new TerraformBiome.Template(TerraformBiome.builder()
            .configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.SAND_CONFIG).category(Biome.Category.DESERT)
            .depth(0.125F)
            .scale(0.05F)
            .precipitation(Biome.Precipitation.NONE)
            .temperature(2.0F)
            .downfall(0.0F)
            .waterColor(4159204)
            .waterFogColor(329011)
            .addStructureFeatures(DefaultBiomeFeatures.DESERT_PYRAMID, DefaultBiomeFeatures.PILLAGER_OUTPOST, DefaultBiomeFeatures.STRONGHOLD, DefaultBiomeFeatures.NORMAL_MINESHAFT)
            .addDefaultFeatures(LAND_CARVERS, STRUCTURES, DUNGEONS, MINEABLES, ORES, DISKS,
                    DEFAULT_FLOWERS, DEFAULT_MUSHROOMS, DEFAULT_GRASS, DESERT_VEGETATION, FOSSILS, SPRINGS)
            .addDefaultSpawnEntries()
            .addSpawnEntry(new Biome.SpawnEntry(EntityType.HUSK, 80, 4, 4))
    );
    public static void register() {
        Biome red_desert = template.builder()
                .configureSurfaceBuilder(SurfaceBuilder.DEFAULT, new TernarySurfaceConfig(Blocks.RED_SAND.getDefaultState(), Blocks.RED_SAND.getDefaultState(), Blocks.GRAVEL.getDefaultState()))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.CACTUS_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(5))))
                .build();
        OverworldBiomes.addBiomeVariant(Biomes.DESERT, BiomeRegistry.register("red_desert", red_desert), 0.1);
        Biome oasis = template.builder()
                .configureSurfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_CONFIG)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.GRASS_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(2))))
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.JUNGLE_TREE_CONFIG), 3)
                .addTreeFeature(Feature.TREE.configure(DefaultBiomeFeatures.JUNGLE_TREE_CONFIG), 1)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.SUGAR_CANE_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(200))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.LILY_PAD_CONFIG)
                        .createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(1))))
                .depth(-0.25f)
                .scale(0)
                .temperature(1)
                .downfall(1)
                .waterColor(4445678)
                .waterFogColor(270131)
                .addStructureFeature(VILLAGE_18)
                .build();

        oasis = BiomeRegistry.register("oasis", oasis);
        OverworldBiomes.addHillsBiome(Biomes.DESERT, oasis, 0.1F);
        OverworldBiomes.addHillsBiome(red_desert, oasis, 0.05F);

        Biome lush_desert = template.builder()
                .depth(0.075F)
                .addStructureFeature(VILLAGE_12)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.CACTUS_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(100))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.DEAD_BUSH_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(5))))
                .addDefaultFeature(LAKES)
                .build();
        OverworldBiomes.addHillsBiome(Biomes.DESERT, BiomeRegistry.register("lush_desert", lush_desert), 1.F);

        Biome barren_desert = template.builder()
                .depth(0.2F)
                .scale(0.1F)
                .build();
        OverworldBiomes.addHillsBiome(Biomes.DESERT, BiomeRegistry.register("barren_desert", barren_desert), 2.F);

        Biome desert_plateau = template.builder()
                .depth(1.5F)
                .scale(0.025F)
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.CACTUS_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(10))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.DEAD_BUSH_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(2))))
                .build();
        OverworldBiomes.addHillsBiome(Biomes.DESERT, BiomeRegistry.register("desert_plateau", desert_plateau), 1.F);

        Biome red_desert_plateau = template.builder()
                .depth(1.5F)
                .scale(0.025F)
                .configureSurfaceBuilder(SurfaceBuilder.DEFAULT, new TernarySurfaceConfig(Blocks.RED_SAND.getDefaultState(), Blocks.RED_SAND.getDefaultState(), Blocks.GRAVEL.getDefaultState()))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.CACTUS_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(10))))
                .addCustomFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.RANDOM_PATCH.configure(DefaultBiomeFeatures.DEAD_BUSH_CONFIG).createDecoratedFeature(Decorator.COUNT_HEIGHTMAP_DOUBLE.configure(new CountDecoratorConfig(2))))
                .build();
        OverworldBiomes.addHillsBiome(red_desert, BiomeRegistry.register("red_desert_plateau", red_desert_plateau), 1.F);
    }
}