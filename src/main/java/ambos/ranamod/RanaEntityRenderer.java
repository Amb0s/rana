package ambos.ranamod;

import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class RanaEntityRenderer extends MobEntityRenderer<RanaEntity, RanaEntityModel> {
    public RanaEntityRenderer(EntityRenderDispatcher entityRenderDispatcher_1) {
        super(entityRenderDispatcher_1, new RanaEntityModel(), 0.48F);
    }

    @Override
    protected Identifier getTexture(RanaEntity ranaEntity) {
        return new Identifier("ranamod:textures/entity/rana/rana.png");
    }
}
