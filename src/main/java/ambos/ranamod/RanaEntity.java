package ambos.ranamod;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class RanaEntity extends AnimalEntity {
    protected RanaEntity(EntityType<? extends AnimalEntity> entityType_1, World world_1) {
        super(entityType_1, world_1);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 2.0D));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(4, new LookAroundGoal(this));
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.MAX_HEALTH).setBaseValue(16.0D);
        this.getAttributeInstance(EntityAttributes.MOVEMENT_SPEED).setBaseValue(0.18D);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource_1) {
        return RanaModClientInit.ENTITY_RANA_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return RanaModClientInit.ENTITY_RANA_DEATH;
    }

    @Override
    protected int getCurrentExperience(PlayerEntity playerEntity_1) {
        return 3 + this.world.random.nextInt(5);
    }

    @Override
    public boolean canEat() {
        return false;
    }

    @Override
    public boolean isBreedingItem(ItemStack itemStack_1) {
        return false;
    }

    @Override
    public boolean isInLove() {
        return false;
    }

    @Override
    public boolean interactMob(PlayerEntity playerEntity_1, Hand hand_1) {
        return false;
    }

    @Override
    public boolean canBreedWith(AnimalEntity animalEntity_1) {
        return false;
    }

    @Override
    public PassiveEntity createChild(PassiveEntity passiveEntity) {
        return null;
    }
}
