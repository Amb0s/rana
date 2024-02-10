package ambos.rana;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class RanaEntity extends AnimalEntity {
    protected RanaEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 2.0D));
        this.goalSelector.add(2, new WanderAroundFarGoal(this, 1.0D));
        this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(4, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createRanaAttributes() {
        return PassiveEntity.createMobAttributes()
        .add(EntityAttributes.GENERIC_MAX_HEALTH, 16.0)
        .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.18f);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return RanaModClientInit.ENTITY_RANA_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return RanaModClientInit.ENTITY_RANA_DEATH;
    }

    @Override
    public int getXpToDrop() {
        return 3 + this.world.random.nextInt(5);
    }

    @Override
    public boolean canEat() {
        return false;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return false;
    }

    @Override
    public boolean isInLove() {
        return false;
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        return ActionResult.FAIL;
    }

    @Override
    public boolean canBreedWith(AnimalEntity other) {
        return false;
    }

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity passiceEntity) {
        return null;
    }
}
