package me.rexysaur.ccraft.objects.blocks.containers.generators;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * generator - rexysaur
 * Created using Tabula 7.1.0
 */
public class ModelGenerator extends ModelBase {
    public ModelRenderer shape1;

    public ModelGenerator() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(-8.0F, 8.0F, -8.0F);
        this.shape1.addBox(0.0F, 0.0F, -0.2F, 16, 16, 16, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.shape1.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
