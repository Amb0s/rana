package ambos.ranamod;

import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.model.Cuboid;
import net.minecraft.item.CrossbowItem;
import net.minecraft.util.AbsoluteHand;
import net.minecraft.util.math.MathHelper;

public class RanaEntityModel extends BipedEntityModel<RanaEntity> {
    private final Cuboid body;
    private final Cuboid waist;
    private final Cuboid head;
    private final Cuboid hat;
    private final Cuboid rightArm;
    private final Cuboid leftArm;
    private final Cuboid rightLeg;
    private final Cuboid leftLeg;

    public RanaEntityModel() {
        textureWidth = 64;
        textureHeight = 64;

        hat = new Cuboid(this);
        hat.setRotationPoint(0.0F, 0.0F, 0.0F);
        hat.addBox("hat", -4.0F, -5.0F, -4.0F, 8, 4, 8, 0.5F, 32, 0);
        hat.addBox("hat", -4.0F, -8.0F, -3.0F, 3, 2, 1, 0.5F, 0, 48);
        hat.addBox("hat", 1.0F, -8.0F, -3.0F, 3, 2, 1, 0.5F, 40, 42);

        head = new Cuboid(this);
        head.setRotationPoint(0.0F, -4.0F, 0.0F);
        head.addBox("head", -4.0F, 0.0F, -4.0F, 8, 8, 8, 0.0F, 0, 0);
        head.addBox("head", 1.0F, 5.0F, 4.0F, 3, 3, 1, 0.0F, 24, 42);
        head.addBox("head", -4.0F, 5.0F, 4.0F, 3, 3, 1, 0.0F, 32, 42);
        head.addBox("head", -4.0F, 6.0F, 5.0F, 2, 2, 1, 0.0F, 8, 48);
        head.addBox("head", 2.0F, 6.0F, 5.0F, 2, 2, 1, 0.0F, 14, 48);
        head.addBox("head", 3.0F, 7.0F, 5.0F, 3, 3, 3, 0.0F, 0, 42);
        head.addBox("head", -6.0F, 7.0F, 5.0F, 3, 3, 3, 0.0F, 12, 42);

        body = new Cuboid(this);
        body.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addBox("body", -3.0F, 4.0F, -2.0F, 6, 10, 3, 0.0F, 0, 16);
        body.addBox("body", -2.0F, 5.0F, 1.0F, 4, 5, 2, 0.0F, 24, 29);

        rightArm = new Cuboid(this);
        rightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        rightArm.addBox("rightArm", -1.0F, 2.0F, -2.0F, 3, 10, 3, 0.0F, 18, 16);

        leftArm = new Cuboid(this);
        leftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
        leftArm.addBox("leftArm", -2.0F, 2.0F, -2.0F, 3, 10, 3, 0.0F, 0, 29);

        waist = new Cuboid(this);
        waist.setRotationPoint(0.0F, 12.0F, 0.0F);

        rightLeg = new Cuboid(this);
        rightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
        rightLeg.addBox("rightLeg", -1.0F, 2.0F, -2.0F, 3, 10, 3, 0.0F, 30, 16);

        leftLeg = new Cuboid(this);
        leftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
        leftLeg.addBox("leftLeg", -2.0F, 2.0F, -2.0F, 3, 10, 3, 0.0F, 12, 29);
    }

    @Override
    public void render(RanaEntity entity, float float_1, float float_2, float float_3, float float_4, float float_5, float float_6) {
        hat.render(float_6);
        head.render(float_6);
        body.render(float_6);
        rightArm.render(float_6);
        leftArm.render(float_6);
        waist.render(float_6);
        rightLeg.render(float_6);
        leftLeg.render(float_6);
    }

    @Override
    public void method_17087(RanaEntity entity, float float_1, float float_2, float float_3, float float_4, float float_5, float float_6) {
        // Rotation points
        this.rightArm.rotationPointZ = 0.0F;
        this.rightArm.rotationPointX = -4.8F;
        this.leftArm.rotationPointZ = 0.0F;
        this.leftArm.rotationPointX = 4.8F;

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
        float float_7 = 1.0F;

        this.rightArm.pitch = MathHelper.cos(float_1 * 0.6662F + 3.1415927F) * 2.0F * float_2 * 0.5F / float_7;
        this.leftArm.pitch = MathHelper.cos(float_1 * 0.6662F) * 2.0F * float_2 * 0.5F / float_7;
        this.rightLeg.pitch = MathHelper.cos(float_1 * 0.6662F) * 1.4F * float_2 / float_7;
        this.leftLeg.pitch = MathHelper.cos(float_1 * 0.6662F + 3.1415927F) * 1.4F * float_2 / float_7;

        // Respiration animation
        Cuboid var10000;

        var10000 = this.rightArm;
        var10000.roll += MathHelper.cos(float_3 * 0.09F) * 0.05F + 0.05F;
        var10000 = this.leftArm;
        var10000.roll -= MathHelper.cos(float_3 * 0.09F) * 0.05F + 0.05F;
        var10000 = this.rightArm;
        var10000.pitch += MathHelper.sin(float_3 * 0.067F) * 0.05F;
        var10000 = this.leftArm;
        var10000.pitch -= MathHelper.sin(float_3 * 0.067F) * 0.05F;
    }
}