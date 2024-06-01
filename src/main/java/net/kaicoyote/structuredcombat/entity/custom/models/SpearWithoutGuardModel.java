package net.kaicoyote.structuredcombat.entity.custom.models;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class SpearWithoutGuardModel extends Model {
    private final ModelPart spearWithoutGuard;

    public SpearWithoutGuardModel(ModelPart root) {
        super(RenderType::entitySolid);
        this.spearWithoutGuard = root;
    }

    public static LayerDefinition createLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition spearWithoutGuard = partdefinition.addOrReplaceChild("spearWithoutGuard", CubeListBuilder.create().texOffs(12, 0).addBox(14.0F, 13.0F, -0.5F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 16).addBox(13.0F, 12.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 19).addBox(12.0F, 11.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(3, 24).addBox(11.0F, 10.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(10, 23).addBox(10.0F, 9.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(23, 8).addBox(9.0F, 8.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(23, 4).addBox(8.0F, 7.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(15, 22).addBox(7.0F, 6.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(22, 0).addBox(6.0F, 5.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 21).addBox(5.0F, 4.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(21, 16).addBox(4.0F, 3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(21, 12).addBox(3.0F, 2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 21).addBox(2.0F, 1.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 21).addBox(1.0F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 19).addBox(0.0F, -1.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(19, 8).addBox(-1.0F, -2.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(19, 4).addBox(-2.0F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(17, 18).addBox(-3.0F, -4.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(3, 18).addBox(-4.0F, -5.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(4, 12).addBox(-5.0F, -6.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(11, 11).addBox(-6.0F, -7.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(15, 9).addBox(-7.0F, -8.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(11, 5).addBox(-8.0F, -9.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(15, 4).addBox(-9.0F, -11.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(-10.0F, -12.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 0).addBox(-11.0F, -13.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 8).addBox(-12.0F, -14.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(7, 7).addBox(-13.0F, -15.0F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 15).addBox(-14.0F, -12.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 17).addBox(-15.0F, -13.0F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-16.0F, -16.0F, -0.5F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.5F, 0.0F, 0.0F, 0.0F, 0.7854F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }


    @Override
    public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        spearWithoutGuard.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
