package ambos.rana;

import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class RanaEntityModel extends BipedEntityModel<RanaEntity> {
    public RanaEntityModel(ModelPart root) {
        super(root);
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        ModelPartData head = modelPartData.addChild(EntityModelPartNames.HEAD,
                ModelPartBuilder.create().uv(1, 1).cuboid(-4.0F, -4.0F, -3.5F, 8.0F, 8.0F, 7.0F, new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        ModelPartData ponyTails = head.addChild("ponyTails", ModelPartBuilder.create(),
                ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        ponyTails.addChild("rightPonytail",
                ModelPartBuilder.create().uv(14, 43).cuboid(-4.0F, 2.0F, 4.5F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F))
                        .uv(0, 42).mirrored().cuboid(-6.0F, 3.0F, 5.5F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F))
                        .mirrored(false),
                ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        ponyTails.addChild("leftPonytail",
                ModelPartBuilder.create().uv(14, 43).mirrored()
                        .cuboid(2.0F, 2.0F, 4.5F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)).mirrored(false)
                        .uv(0, 42).cuboid(3.0F, 3.0F, 5.5F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        head.addChild("scrunchies",
                ModelPartBuilder.create().uv(44, 8).mirrored()
                        .cuboid(1.0F, 1.0F, 3.5F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
                        .uv(44, 8).cuboid(-4.0F, 1.0F, 3.5F, 3.0F, 3.0F, 1.0F, new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        ModelPartData hat = modelPartData.addChild(EntityModelPartNames.HAT,
                ModelPartBuilder.create().uv(33, 1).cuboid(-4.0F, -4.0F, -3.5F, 8.0F, 3.0F, 7.0F, new Dilation(0.5F)),
                ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        hat.addChild("eyes",
                ModelPartBuilder.create().uv(0, 48).mirrored()
                        .cuboid(1.0F, -6.5F, -3.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)).mirrored(false)
                        .uv(0, 48).cuboid(-4.0F, -6.5F, -3.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.BODY,
                ModelPartBuilder.create().uv(0, 16).cuboid(-3.0F, 4.0F, -1.5F, 6.0F, 10.0F, 3.0F, new Dilation(0.0F)),
                ModelTransform.pivot(0.0F, 0.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_ARM,
                ModelPartBuilder.create().uv(0, 29).cuboid(-2.0F, 2.0F, -1.5F, 3.0F, 10.0F, 3.0F, new Dilation(0.0F)),
                ModelTransform.pivot(5.0F, 2.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.RIGHT_ARM,
                ModelPartBuilder.create().uv(0, 29).mirrored()
                        .cuboid(-1.0F, 2.0F, -1.5F, 3.0F, 10.0F, 3.0F, new Dilation(0.0F)).mirrored(false),
                ModelTransform.pivot(-5.0F, 2.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_LEG,
                ModelPartBuilder.create().uv(12, 29).mirrored()
                        .cuboid(-1.9F, 2.0F, -1.5F, 3.0F, 10.0F, 3.0F, new Dilation(0.0F)).mirrored(false),
                ModelTransform.pivot(1.9F, 12.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.RIGHT_LEG,
                ModelPartBuilder.create().uv(12, 29).cuboid(-1.1F, 2.0F, -1.5F, 3.0F, 10.0F, 3.0F, new Dilation(0.0F)),
                ModelTransform.pivot(-1.9F, 12.0F, 0.0F));

        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(RanaEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
            float headPitch) {
        // Rotation points
        this.rightArm.pivotZ = 0.0F;
        this.rightArm.pivotX = -4.85F;
        this.leftArm.pivotZ = 0.0F;
        this.leftArm.pivotX = 4.85F;

        // Yaw
        this.body.yaw = 0.0F;
        this.rightLeg.yaw = 0.0F;
        this.leftLeg.yaw = 0.0F;
        this.rightArm.yaw = 0.0F;

        // Roll
        this.rightArm.roll = 0.0F;
        this.leftArm.roll = 0.0F;
        this.rightLeg.roll = 0.0F;
        this.leftLeg.roll = 0.0F;

        // Pitch
        float k = 1.0F;

        this.rightArm.pitch = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 2.0F * limbSwingAmount * 0.5F / k;
        this.leftArm.pitch = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F / k;
        this.rightLeg.pitch = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / k;
        this.leftLeg.pitch = MathHelper.cos(limbSwing * 0.6662F + 3.1415927F) * 1.4F * limbSwingAmount / k;

        // Respiration animation
        ModelPart modelPart;

        modelPart = this.rightArm;
        modelPart.roll += MathHelper.cos(ageInTicks * 0.09F) * 0.02F + 0.04F;
        modelPart = this.leftArm;
        modelPart.roll -= MathHelper.cos(ageInTicks * 0.09F) * 0.02F + 0.04F;
        modelPart = this.rightArm;
        modelPart.pitch += MathHelper.sin(ageInTicks * 0.067F) * 0.02F;
        modelPart = this.leftArm;
        modelPart.pitch -= MathHelper.sin(ageInTicks * 0.067F) * 0.02F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red,
            float green, float blue, float alpha) {
        head.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        hat.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        body.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        leftArm.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        rightArm.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        leftLeg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
        rightLeg.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }
}
