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

        body = new Cuboid(this);
        body.setRotationPoint(0.0F, 0.0F, 0.0F);
        body.addBox("body", -3.0F, 4.0F, -2.0F, 6, 10, 3, 0.0F, 0, 16);
        body.addBox("body", -2.0F, 5.0F, 1.0F, 4, 5, 2, 0.0F, 24, 29);

        waist = new Cuboid(this);
        waist.setRotationPoint(0.0F, 12.0F, 0.0F);

        head = new Cuboid(this);
        head.setRotationPoint(0.0F, -4.0F, 0.0F);
        head.addBox("head", -4.0F, 0.0F, -4.0F, 8, 8, 8, 0.0F, 0, 0);
        head.addBox("head", 1.0F, 5.0F, 4.0F, 3, 3, 1, 0.0F, 24, 42);
        head.addBox("head", -4.0F, 5.0F, 4.0F, 3, 3, 1, 0.0F, 32, 42);
        head.addBox("head", -4.0F, 6.0F, 5.0F, 2, 2, 1, 0.0F, 8, 48);
        head.addBox("head", 2.0F, 6.0F, 5.0F, 2, 2, 1, 0.0F, 14, 48);
        head.addBox("head", 3.0F, 7.0F, 5.0F, 3, 3, 3, 0.0F, 0, 42);
        head.addBox("head", -6.0F, 7.0F, 5.0F, 3, 3, 3, 0.0F, 12, 42);

        hat = new Cuboid(this);
        hat.setRotationPoint(0.0F, 0.0F, 0.0F);
        hat.addBox("hat", -4.0F, -5.0F, -4.0F, 8, 4, 8, 0.5F, 32, 0);
        hat.addBox("hat", -4.0F, -8.0F, -3.0F, 3, 2, 1, 0.5F, 0, 48);
        hat.addBox("hat", 1.0F, -8.0F, -3.0F, 3, 2, 1, 0.5F, 40, 42);

        rightArm = new Cuboid(this);
        rightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        rightArm.addBox("rightArm", -1.0F, 2.0F, -2.0F, 3, 10, 3, 0.0F, 18, 16);

        leftArm = new Cuboid(this);
        leftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
        leftArm.addBox("leftArm", -2.0F, 2.0F, -2.0F, 3, 10, 3, 0.0F, 0, 29);

        rightLeg = new Cuboid(this);
        rightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
        rightLeg.addBox("rightLeg", -1.0F, 2.0F, -2.0F, 3, 10, 3, 0.0F, 30, 16);

        leftLeg = new Cuboid(this);
        leftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
        leftLeg.addBox("leftLeg", -2.0F, 2.0F, -2.0F, 3, 10, 3, 0.0F, 12, 29);
    }

    @Override
    public void render(RanaEntity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        body.render(f5);
        waist.render(f5);
        head.render(f5);
        hat.render(f5);
        rightArm.render(f5);
        leftArm.render(f5);
        rightLeg.render(f5);
        leftLeg.render(f5);
    }

    private float method_2807(float float_1) {
        return -65.0F * float_1 + float_1 * float_1;
    }

    @Override
    public void method_17087(RanaEntity livingEntity_1, float float_1, float float_2, float float_3, float float_4, float float_5, float float_6) {
        boolean boolean_1 = livingEntity_1.method_6003() > 4;

        this.body.yaw = 0.0F;
        this.rightArm.rotationPointZ = 0.0F;
        this.rightArm.rotationPointX = -5.0F;
        this.leftArm.rotationPointZ = 0.0F;
        this.leftArm.rotationPointX = 5.0F;
        float float_7 = 1.0F;
        if (boolean_1) {
            float_7 = (float)livingEntity_1.getVelocity().lengthSquared();
            float_7 /= 0.2F;
            float_7 *= float_7 * float_7;
        }

        if (float_7 < 1.0F) {
            float_7 = 1.0F;
        }

        this.rightArm.pitch = MathHelper.cos(float_1 * 0.6662F + 3.1415927F) * 2.0F * float_2 * 0.5F / float_7;
        this.leftArm.pitch = MathHelper.cos(float_1 * 0.6662F) * 2.0F * float_2 * 0.5F / float_7;
        this.rightArm.roll = 0.0F;
        this.leftArm.roll = 0.0F;
        this.rightLeg.pitch = MathHelper.cos(float_1 * 0.6662F) * 1.4F * float_2 / float_7;
        this.leftLeg.pitch = MathHelper.cos(float_1 * 0.6662F + 3.1415927F) * 1.4F * float_2 / float_7;
        this.rightLeg.yaw = 0.0F;
        this.leftLeg.yaw = 0.0F;
        this.rightLeg.roll = 0.0F;
        this.leftLeg.roll = 0.0F;

        Cuboid var10000;

        if (this.isRiding) {
            var10000 = this.rightArm;
            var10000.pitch += -0.62831855F;
            var10000 = this.leftArm;
            var10000.pitch += -0.62831855F;
            this.rightLeg.pitch = -1.4137167F;
            this.rightLeg.yaw = 0.31415927F;
            this.rightLeg.roll = 0.07853982F;
            this.leftLeg.pitch = -1.4137167F;
            this.leftLeg.yaw = -0.31415927F;
            this.leftLeg.roll = -0.07853982F;
        }

        this.rightArm.yaw = 0.0F;
        this.rightArm.roll = 0.0F;

        switch(this.leftArmPose) {
            case EMPTY:
                this.leftArm.yaw = 0.0F;
                break;
            case BLOCK:
                this.leftArm.pitch = this.leftArm.pitch * 0.5F - 0.9424779F;
                this.leftArm.yaw = 0.5235988F;
                break;
            case ITEM:
                this.leftArm.pitch = this.leftArm.pitch * 0.5F - 0.31415927F;
                this.leftArm.yaw = 0.0F;
        }

        switch(this.rightArmPose) {
            case EMPTY:
                this.rightArm.yaw = 0.0F;
                break;
            case BLOCK:
                this.rightArm.pitch = this.rightArm.pitch * 0.5F - 0.9424779F;
                this.rightArm.yaw = -0.5235988F;
                break;
            case ITEM:
                this.rightArm.pitch = this.rightArm.pitch * 0.5F - 0.31415927F;
                this.rightArm.yaw = 0.0F;
                break;
            case THROW_SPEAR:
                this.rightArm.pitch = this.rightArm.pitch * 0.5F - 3.1415927F;
                this.rightArm.yaw = 0.0F;
        }

        if (this.leftArmPose == BipedEntityModel.ArmPose.THROW_SPEAR && this.rightArmPose != BipedEntityModel.ArmPose.BLOCK && this.rightArmPose != BipedEntityModel.ArmPose.THROW_SPEAR && this.rightArmPose != BipedEntityModel.ArmPose.BOW_AND_ARROW) {
            this.leftArm.pitch = this.leftArm.pitch * 0.5F - 3.1415927F;
            this.leftArm.yaw = 0.0F;
        }

        float float_15;
        float float_17;
        float float_19;

        if (this.handSwingProgress > 0.0F) {
            AbsoluteHand absoluteHand_1 = this.getPreferedHand(livingEntity_1);
            Cuboid cuboid_1 = this.getArm(absoluteHand_1);
            float_15 = this.handSwingProgress;

            this.body.yaw = MathHelper.sin(MathHelper.sqrt(float_15) * 6.2831855F) * 0.2F;

            if (absoluteHand_1 == AbsoluteHand.LEFT) {
                var10000 = this.body;
                var10000.yaw *= -1.0F;
            }

            this.rightArm.rotationPointZ = MathHelper.sin(this.body.yaw) * 5.0F;
            this.rightArm.rotationPointX = -MathHelper.cos(this.body.yaw) * 5.0F;
            this.leftArm.rotationPointZ = -MathHelper.sin(this.body.yaw) * 5.0F;
            this.leftArm.rotationPointX = MathHelper.cos(this.body.yaw) * 5.0F;

            var10000 = this.rightArm;
            var10000.yaw += this.body.yaw;
            var10000 = this.leftArm;
            var10000.yaw += this.body.yaw;
            var10000 = this.leftArm;
            var10000.pitch += this.body.yaw;
            float_15 = 1.0F - this.handSwingProgress;
            float_15 *= float_15;
            float_15 *= float_15;
            float_15 = 1.0F - float_15;
            float_17 = MathHelper.sin(float_15 * 3.1415927F);
            float_19 = MathHelper.sin(this.handSwingProgress * 3.1415927F) *  (-0.7F) * 0.75F;
            cuboid_1.pitch = (float)((double)cuboid_1.pitch - ((double)float_17 * 1.2D + (double)float_19));
            cuboid_1.yaw += this.body.yaw * 2.0F;
            cuboid_1.roll += MathHelper.sin(this.handSwingProgress * 3.1415927F) * -0.4F;
        }

        if (this.isSneaking) {
            this.body.pitch = 0.5F;
            var10000 = this.rightArm;
            var10000.pitch += 0.4F;
            var10000 = this.leftArm;
            var10000.pitch += 0.4F;
            this.rightLeg.rotationPointZ = 4.0F;
            this.leftLeg.rotationPointZ = 4.0F;
            this.rightLeg.rotationPointY = 9.0F;
            this.leftLeg.rotationPointY = 9.0F;
        } else {
            this.body.pitch = 0.0F;
            this.rightLeg.rotationPointZ = 0.1F;
            this.leftLeg.rotationPointZ = 0.1F;
            this.rightLeg.rotationPointY = 12.0F;
            this.leftLeg.rotationPointY = 12.0F;
        }

        var10000 = this.rightArm;
        var10000.roll += MathHelper.cos(float_3 * 0.09F) * 0.05F + 0.05F;
        var10000 = this.leftArm;
        var10000.roll -= MathHelper.cos(float_3 * 0.09F) * 0.05F + 0.05F;
        var10000 = this.rightArm;
        var10000.pitch += MathHelper.sin(float_3 * 0.067F) * 0.05F;
        var10000 = this.leftArm;
        var10000.pitch -= MathHelper.sin(float_3 * 0.067F) * 0.05F;

        if (this.rightArmPose == BipedEntityModel.ArmPose.BOW_AND_ARROW) {
            this.rightArm.yaw = -0.1F;
            this.leftArm.yaw = 0.1F + 0.4F;
            this.rightArm.pitch = -1.5707964F;
            this.leftArm.pitch = -1.5707964F;
        } else if (this.leftArmPose == BipedEntityModel.ArmPose.BOW_AND_ARROW && this.rightArmPose != BipedEntityModel.ArmPose.THROW_SPEAR && this.rightArmPose != BipedEntityModel.ArmPose.BLOCK) {
            this.rightArm.yaw = -0.1F - 0.4F;
            this.leftArm.yaw = 0.1F;
            this.rightArm.pitch = -1.5707964F;
            this.leftArm.pitch = -1.5707964F;
        }

        float float_11 = (float) CrossbowItem.getPullTime(livingEntity_1.getActiveItem());
        float float_14;

        if (this.rightArmPose == BipedEntityModel.ArmPose.CROSSBOW_CHARGE) {
            this.rightArm.yaw = -0.8F;
            this.rightArm.pitch = -0.97079635F;
            this.leftArm.pitch = -0.97079635F;
            float_14 = MathHelper.clamp((float)livingEntity_1.getItemUseTime(), 0.0F, float_11);
            this.leftArm.yaw = MathHelper.lerp(float_14 / float_11, 0.4F, 0.85F);
            this.leftArm.pitch = MathHelper.lerp(float_14 / float_11, this.leftArm.pitch, -1.5707964F);
        } else if (this.leftArmPose == BipedEntityModel.ArmPose.CROSSBOW_CHARGE) {
            this.leftArm.yaw = 0.8F;
            this.rightArm.pitch = -0.97079635F;
            this.leftArm.pitch = -0.97079635F;
            float_14 = MathHelper.clamp((float)livingEntity_1.getItemUseTime(), 0.0F, float_11);
            this.rightArm.yaw = MathHelper.lerp(float_14 / float_11, -0.4F, -0.85F);
            this.rightArm.pitch = MathHelper.lerp(float_14 / float_11, this.rightArm.pitch, -1.5707964F);
        }

        if (this.rightArmPose == BipedEntityModel.ArmPose.CROSSBOW_HOLD && this.handSwingProgress <= 0.0F) {
            this.rightArm.yaw = -0.3F;
            this.leftArm.yaw = 0.6F;
            this.rightArm.pitch = -1.5707964F + 0.1F;
            this.leftArm.pitch = -1.5F;
        } else if (this.leftArmPose == BipedEntityModel.ArmPose.CROSSBOW_HOLD) {
            this.rightArm.yaw = -0.6F;
            this.leftArm.yaw = 0.3F;
            this.rightArm.pitch = -1.5F;
            this.leftArm.pitch = -1.5707964F;
        }

        if (this.field_3396 > 0.0F) {
            float_14 = float_1 % 26.0F;
            float_15 = this.handSwingProgress > 0.0F ? 0.0F : this.field_3396;
            if (float_14 < 14.0F) {
                this.leftArm.pitch = this.method_2804(this.leftArm.pitch, 0.0F, this.field_3396);
                this.rightArm.pitch = MathHelper.lerp(float_15, this.rightArm.pitch, 0.0F);
                this.leftArm.yaw = this.method_2804(this.leftArm.yaw, 3.1415927F, this.field_3396);
                this.rightArm.yaw = MathHelper.lerp(float_15, this.rightArm.yaw, 3.1415927F);
                this.leftArm.roll = this.method_2804(this.leftArm.roll, 3.1415927F + 1.8707964F * this.method_2807(float_14) / this.method_2807(14.0F), this.field_3396);
                this.rightArm.roll = MathHelper.lerp(float_15, this.rightArm.roll, 3.1415927F - 1.8707964F * this.method_2807(float_14) / this.method_2807(14.0F));
            } else if (float_14 >= 14.0F && float_14 < 22.0F) {
                float_17 = (float_14 - 14.0F) / 8.0F;
                this.leftArm.pitch = this.method_2804(this.leftArm.pitch, 1.5707964F * float_17, this.field_3396);
                this.rightArm.pitch = MathHelper.lerp(float_15, this.rightArm.pitch, 1.5707964F * float_17);
                this.leftArm.yaw = this.method_2804(this.leftArm.yaw, 3.1415927F, this.field_3396);
                this.rightArm.yaw = MathHelper.lerp(float_15, this.rightArm.yaw, 3.1415927F);
                this.leftArm.roll = this.method_2804(this.leftArm.roll, 5.012389F - 1.8707964F * float_17, this.field_3396);
                this.rightArm.roll = MathHelper.lerp(float_15, this.rightArm.roll, 1.2707963F + 1.8707964F * float_17);
            } else if (float_14 >= 22.0F && float_14 < 26.0F) {
                float_17 = (float_14 - 22.0F) / 4.0F;
                this.leftArm.pitch = this.method_2804(this.leftArm.pitch, 1.5707964F - 1.5707964F * float_17, this.field_3396);
                this.rightArm.pitch = MathHelper.lerp(float_15, this.rightArm.pitch, 1.5707964F - 1.5707964F * float_17);
                this.leftArm.yaw = this.method_2804(this.leftArm.yaw, 3.1415927F, this.field_3396);
                this.rightArm.yaw = MathHelper.lerp(float_15, this.rightArm.yaw, 3.1415927F);
                this.leftArm.roll = this.method_2804(this.leftArm.roll, 3.1415927F, this.field_3396);
                this.rightArm.roll = MathHelper.lerp(float_15, this.rightArm.roll, 3.1415927F);
            }

            float_17 = 0.3F;
            float_19 = 0.33333334F;
            this.leftLeg.pitch = MathHelper.lerp(this.field_3396, this.leftLeg.pitch, 0.3F * MathHelper.cos(float_1 * 0.33333334F + 3.1415927F));
            this.rightLeg.pitch = MathHelper.lerp(this.field_3396, this.rightLeg.pitch, 0.3F * MathHelper.cos(float_1 * 0.33333334F));
        }
    }
}