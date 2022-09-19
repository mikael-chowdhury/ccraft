package me.rexysaur.ccraft.entity.test;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityTest extends EntityAgeable {
	public EntityTest(World worldIn) {
		super(worldIn);
		this.setSize(5, 5);
	}
	
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(2, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIWander(this, 0.3D));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.5D, true));
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.20115f);
		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(10.0D);
	}

	@Override
	public EntityAgeable createChild(EntityAgeable ageable) {
		this.setSize(0.5f, 0.5f);
		return new EntityTest(world);
	}
	
//	@Override
//	protected SoundEvent getDeathSound() {
//		return  SoundsHandler.TEST_DEATH;
//	}
//	
//	@Override
//	protected SoundEvent getAmbientSound() {
//		return SoundsHandler.TEST_AMBIENT
//	}
//	
//	@Override
//	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
//		return SoundsHandler.TEST_HURT
//	}
//	
//	@Override
//	protected ResourceLocation getLootTable() {
//		return
//	}
}
