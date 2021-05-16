package io.itch.awesomekalin.noob.objects.blocks.noob_chest;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * NoobChest - AwesomeKalin55
 * Created using Tabula 7.1.0
 */
@SideOnly(Side.CLIENT)
public class ModelNoobChest extends ModelBase {
    public ModelRenderer shape1;

    public ModelNoobChest() {
        this.textureWidth = 16;
        this.textureHeight = 16;
        this.shape1 = new ModelRenderer(this, 0, 0);
        this.shape1.setRotationPoint(1.0F, 6.0F, 1.0F);
        this.shape1.addBox(0.0F, 0.0F, 0.0F, 16, 16, 16, 0.0F);
    }

    public void renderAll() {
        this.shape1.render(0.0625F);
    }
}
