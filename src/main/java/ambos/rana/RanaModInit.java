package ambos.rana;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RanaModInit implements ModInitializer {
    // Registers Rana.
    public static final EntityType<RanaEntity> RANA = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier("rana", "rana"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, RanaEntity::new)
                    .dimensions(EntityDimensions.fixed(0.48f, 1.7f)).build());

    @Override
    public void onInitialize() {
        FabricDefaultAttributeRegistry.register(RANA, RanaEntity.createRanaAttributes());

        // Registers spawn egg.
        Registry.register(Registries.ITEM, new Identifier("rana", "rana_spawn_egg"),
                new SpawnEggItem(RANA, 0x009147, 0x006934, new Item.Settings().maxCount(64)));
    }
}
