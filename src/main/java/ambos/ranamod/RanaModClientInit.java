package ambos.ranamod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.EntityRendererRegistry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RanaModClientInit implements ClientModInitializer {
    public static final SoundEvent ENTITY_RANA_HURT = Registry.register(Registry.SOUND_EVENT,
            "entity.rana.hurt", new SoundEvent(new Identifier("ranamod", "entity.rana.hurt")));
    public static final SoundEvent ENTITY_RANA_DEATH = Registry.register(Registry.SOUND_EVENT,
            "entity.rana.death", new SoundEvent(new Identifier("ranamod", "entity.rana.death")));

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(RanaEntity.class,
                (entityRenderDispatcher, context) -> new RanaEntityRenderer(entityRenderDispatcher));
    }
}
