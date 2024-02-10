package ambos.rana;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class RanaEntityRenderer extends MobEntityRenderer<RanaEntity, RanaEntityModel> {
    public RanaEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new RanaEntityModel(context.getPart(RanaModClientInit.MODEL_CUBE_LAYER)), 0.48f);
    }

    @Override
    public Identifier getTexture(RanaEntity ranaEntity) {
        return new Identifier("rana:textures/entity/rana/rana.png");
    }
}
