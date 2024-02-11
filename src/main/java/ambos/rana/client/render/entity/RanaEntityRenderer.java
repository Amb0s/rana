package ambos.rana.client.render.entity;

import ambos.rana.Rana;
import ambos.rana.RanaClient;
import ambos.rana.client.render.entity.model.RanaEntityModel;
import ambos.rana.entity.passive.RanaEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class RanaEntityRenderer extends MobEntityRenderer<RanaEntity, RanaEntityModel> {
    public RanaEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new RanaEntityModel(context.getPart(RanaClient.RANA_MODEL_LAYER)), 0.48f);
    }

    @Override
    public Identifier getTexture(RanaEntity ranaEntity) {
        return new Identifier(Rana.MOD_ID + ":textures/entity/rana/rana.png");
    }
}
