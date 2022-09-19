package me.rexysaur.ccraft.entity.test;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTest extends ModelBase {
    public ModelRenderer shape1;
    public ModelRenderer shape1_1;
    public ModelRenderer shape1_2;
    public ModelRenderer shape1_3;
    public ModelRenderer shape5;

    public ModelTest() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(-7.0F, 19.0F, -7.0F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 2, 5, 1, 0.0F);
        this.shape1_2 = new ModelRenderer(this, 0, 0);
        this.shape1_2.setRotationPoint(5.0F, 19.0F, -7.0F);
        this.shape1_2.addBox(0.0F, 0.0F, 0.0F, 2, 5, 1, 0.0F);
        this.shape1_3 = new ModelRenderer(this, 0, 0);
        this.shape1_3.setRotationPoint(5.0F, 19.0F, 6.0F);
        this.shape1_3.addBox(0.0F, 0.0F, 0.0F, 2, 5, 1, 0.0F);
        this.shape1_1 = new ModelRenderer(this, 0, 0);
        this.shape1_1.setRotationPoint(-7.0F, 19.0F, 6.0F);
        this.shape1_1.addBox(0.0F, 0.0F, 0.0F, 2, 5, 1, 0.0F);
        this.shape5 = new ModelRenderer(this, 0, 0);
        this.shape5.setRotationPoint(-7.0F, 18.0F, -7.0F);
        this.shape5.addBox(0.0F, 0.0F, 0.0F, 14, 2, 14, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape1.render(f5);
        this.shape1_2.render(f5);
        this.shape1_3.render(f5);
        this.shape1_1.render(f5);
        this.shape5.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
    		float headPitch, float scaleFactor, Entity entityIn) {

    }
}
