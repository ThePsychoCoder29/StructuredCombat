package net.kaicoyote.structuredcombat.entity.client.renderer.spear;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.entity.client.ModModelLayers;
import net.kaicoyote.structuredcombat.entity.custom.entities.spears.GoldSpearProjectileEntity;
import net.kaicoyote.structuredcombat.entity.custom.models.SpearWithGuardModel;
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
public class GoldSpearRenderer extends EntityRenderer<GoldSpearProjectileEntity>{
    private final SpearWithGuardModel model;
    public GoldSpearRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new SpearWithGuardModel(pContext.bakeLayer(ModModelLayers.GOLD_SPEAR));
    }

    @Override
    public void render(GoldSpearProjectileEntity pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        pMatrixStack.pushPose();
        pMatrixStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot()) - 90.0F));
        pMatrixStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot()) + 90.0F));
        VertexConsumer $$6 = ItemRenderer.getFoilBufferDirect(pBuffer, this.model.renderType(this.getTextureLocation(pEntity)), false, false);
        this.model.renderToBuffer(pMatrixStack, $$6, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        pMatrixStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull GoldSpearProjectileEntity goldSpearProjectileEntity) {
        return new ResourceLocation(StructuredCombat.MOD_ID, "textures/entity/spears/gold_spear.png");
    }
}
