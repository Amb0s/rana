package ambos.ranamod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RanaModInit implements ModInitializer {
	public static final EntityType<RanaEntity> RANA =
			Registry.register(
					Registry.ENTITY_TYPE,
					new Identifier("ranamod", "rana"),
					FabricEntityTypeBuilder.create(EntityCategory.CREATURE, RanaEntity::new).size(new EntitySize(0.5F,
							1.7F, true)).build()
			);

	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("ranamod", "rana_spawn_egg"),
				new SpawnEggItem(RANA, -16740025, -16750284, new Item.Settings().maxCount(64).group(ItemGroup.MISC)));
	}
}

