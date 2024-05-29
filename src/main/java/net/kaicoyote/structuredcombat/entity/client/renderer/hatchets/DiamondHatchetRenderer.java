package net.kaicoyote.structuredcombat.entity.client.renderer.hatchets;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.entity.client.ModModelLayers;
import net.kaicoyote.structuredcombat.entity.custom.entities.hatchets.DiamondHatchetProjectileEntity;
import net.kaicoyote.structuredcombat.entity.custom.models.HatchetModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class DiamondHatchetRenderer extends EntityRenderer<DiamondHatchetProjectileEntity>{
    private final HatchetModel model;
    public DiamondHatchetRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new HatchetModel(pContext.bakeLayer(ModModelLayers.DIAMOND_HATCHET));
    }

    @Override
    public void render(DiamondHatchetProjectileEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose();
        pMatrixStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot()) - 90.0F));
        pMatrixStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot()) + 90.0F));
        VertexConsumer $$6 = ItemRenderer.getFoilBufferDirect(pBuffer, this.model.renderType(this.getTextureLocation(pEntity)), false, false);
        this.model.renderToBuffer(pMatrixStack, $$6, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        pMatrixStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull DiamondHatchetProjectileEntity diamondHatchetProjectileEntity) {
        return new ResourceLocation(StructuredCombat.MOD_ID, "textures/entity/hatchets/diamond_hatchet.png");
    }
}
