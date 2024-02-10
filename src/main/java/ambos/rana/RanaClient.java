package ambos.rana;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class RanaClient implements ClientModInitializer {
    public static final EntityModelLayer RANA_MODEL_LAYER = new EntityModelLayer(new Identifier("rana", "rana"),
            "main");
    // Registers sounds.
    public static final SoundEvent ENTITY_RANA_HURT = Registry.register(Registries.SOUND_EVENT,
            "entity.rana.hurt", SoundEvent.of(new Identifier("rana", "entity.rana.hurt")));
    public static final SoundEvent ENTITY_RANA_DEATH = Registry.register(Registries.SOUND_EVENT,
            "entity.rana.death", SoundEvent.of(new Identifier("rana", "entity.rana.death")));

    @Override
    public void onInitializeClient() {
        // Connects entity to renderer.
        EntityRendererRegistry.register(Rana.RANA,
                (context) -> new RanaEntityRenderer(context));
        EntityModelLayerRegistry.registerModelLayer(RANA_MODEL_LAYER, RanaEntityModel::getTexturedModelData);
    }
}
