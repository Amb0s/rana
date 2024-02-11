package ambos.rana;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class Rana implements ModInitializer {
    //public static final Logger LOGGER = LoggerFactory.getLogger("rana");

    // Registers Rana.
    public static final EntityType<RanaEntity> RANA = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier("rana", "rana"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RanaEntity::new)
                    .dimensions(EntityDimensions.fixed(0.48f, 1.7f)).build());

    // Declares Rana spawn egg.
    public static final Item RANA_SPAWN_EGG = new SpawnEggItem(RANA, 0x009147, 0x006934,
            new Item.Settings().maxCount(64));

    @Override
    public void onInitialize() {
        // Registers Rana default attributes.
        FabricDefaultAttributeRegistry.register(RANA, RanaEntity.createRanaAttributes());

        // Registers Rana spawn egg.
        Registry.register(Registries.ITEM, new Identifier("rana", "rana_spawn_egg"), RANA_SPAWN_EGG);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(content -> {
            content.add(RANA_SPAWN_EGG);
        });

        // Handles configuration.
        AutoConfig.register(ModConfig.class, Toml4jConfigSerializer::new);
        ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();

        // Makes Rana spawn in selected biomes.
        Identifier biomeIdentifier = null;
        for (String biomeString : config.spawnBiomes) {
            biomeIdentifier = new Identifier(biomeString.split(Identifier.NAMESPACE_SEPARATOR + "")[0],
                    biomeString.split(Identifier.NAMESPACE_SEPARATOR + "")[1]);
            BiomeModifications.addSpawn(
                    BiomeSelectors.includeByKey(RegistryKey.of(RegistryKeys.BIOME, biomeIdentifier)),
                    SpawnGroup.CREATURE, RANA, 8, 1, 3);
        }
    }
}
