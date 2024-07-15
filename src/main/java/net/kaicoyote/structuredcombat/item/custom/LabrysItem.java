package net.kaicoyote.structuredcombat.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.kaicoyote.structuredcombat.item.ModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.List;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class LabrysItem extends AxeItem{

    public LabrysItem(Tier pTier, Properties pProperties) {
        super(pTier, 0, 0, pProperties);
    }

    @Override
    public int getUseDuration(@NotNull ItemStack pStack) {
        return 72000;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        if (slot == EquipmentSlot.MAINHAND){
            if (stack.is(ModItems.WOODEN_LABRYS.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(10));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.5));
                builder.build();
            }
            if (stack.is(ModItems.STONE_LABRYS.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(12));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.5));
                builder.build();
            }
            if (stack.is(ModItems.IRON_LABRYS.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(15));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.5));
                builder.build();
            }
            if (stack.is(ModItems.GOLD_LABRYS.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(10));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.25));
                builder.build();
            }
            if (stack.is(ModItems.DIAMOND_LABRYS.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(18));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.4));
                builder.build();
            }
            if (stack.is(ModItems.NETHERITE_LABRYS.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(20));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3.4));
                builder.build();
            }
        }

        return builder.build();
    }

    @Override
    public void onUseTick(@NotNull Level pLevel, @NotNull LivingEntity pLivingEntity, @NotNull ItemStack pStack, int pRemainingUseDuration) {
        if(pLivingEntity instanceof Player player){
            int duration = player.getTicksUsingItem();
            double radius = 1.5;
            double angular_speed = 0.1;
            float angle = 0;
            if(duration >= 30){
                player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 20, 1, false, false, false));
                AABB damageBox = player.getBoundingBox().inflate(1.5, 1.5, 1.5);
                List<Mob> entities = pLevel.getEntitiesOfClass(Mob.class, damageBox);
                for(Mob mob : entities){
                    mob.knockback(5, 10, 10);
                    mob.hurt(player.damageSources().magic(), 20);
                    pStack.hurtAndBreak(1, player, user -> user.broadcastBreakEvent(player.getUsedItemHand()));
                }
                angle += (float) angular_speed * (duration - 30) ;
                angle %= 360;
                double playerX = player.getBlockX();
                double playerY = player.getBlockY() + 2;
                double playerZ = player.getBlockZ();
                double particleX = playerX + Mth.cos(angle) * radius;
                double particleY = playerY + Mth.sin(angle) * radius;
                double particleZ = playerZ + Mth.cos(angle) * radius;
                for(int i = 0; i < 2; ++i) {
                    pLevel.addParticle(ParticleTypes.CRIT, particleX, particleY, particleZ,
                            0, 0.25, 0);
                }
            }
        }
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, @NotNull Player player, @NotNull InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(itemstack);
    }


    public AttributeModifier attributeDmg(double amountDmg) {
        return new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", amountDmg, AttributeModifier.Operation.ADDITION);
    }

    public  AttributeModifier attributeSpd(double amountSpd) {
        return new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", amountSpd, AttributeModifier.Operation.ADDITION);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()){
            pTooltipComponents.add(Component.translatable("tooltip.structuredcombat.labrys.tooltip"));
        }
        else {
            pTooltipComponents.add(Component.translatable("tooltip.structuredcombat.shift.tooltip"));
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
    }

    @Override
    public boolean canAttackBlock(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, Player pPlayer) {
        return !pPlayer.isCreative();
    }

    @Override
    public boolean canPerformAction(@NotNull ItemStack stack, @NotNull ToolAction toolAction) {
        return ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction);
    }
}
