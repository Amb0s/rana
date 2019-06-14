package ambos.ranamod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.EntityRendererRegistry;

public class RanaModClientInit implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(RanaEntity.class,
                (entityRenderDispatcher, context) -> new RanaEntityRenderer(entityRenderDispatcher));
    }
}
