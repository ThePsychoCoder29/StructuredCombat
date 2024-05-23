package net.kaicoyote.structuredcombat.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.kaicoyote.structuredcombat.entity.custom.entities.daggers.DaggerProjectileEntity;
import net.kaicoyote.structuredcombat.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.extensions.IForgeItem;
import org.apache.commons.lang3.function.TriFunction;
import org.jetbrains.annotations.NotNull;

public class DaggerItem extends Item implements IForgeItem {
    private final TriFunction<Level, Player, ItemStack, DaggerProjectileEntity> constructor;
    public DaggerItem(TriFunction<Level, Player, ItemStack, DaggerProjectileEntity> constructor, Properties pProperties) {
        super(pProperties);
        this.constructor = constructor;
    }


    @Override
    public int getUseDuration(@NotNull ItemStack pStack) {
        return 72000;
    }


    @Override
    public void releaseUsing(@NotNull ItemStack stack, @NotNull Level pLevel, @NotNull LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof Player player) {
            int duration = this.getUseDuration(stack) - pTimeLeft;
            if (duration >= 10) {
                if (!pLevel.isClientSide()) {
                    stack.hurtAndBreak(1, player, (broadcastPlayer) -> broadcastPlayer.broadcastBreakEvent(pEntityLiving.getUsedItemHand()));
                    if(stack.is(this)){
                        DaggerProjectileEntity dagger = this.constructor.apply(pLevel, player, stack);
                        dagger.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.062640088593577F, 1.0F);
                        if (player.getAbilities().instabuild) {
                            dagger.pickup = AbstractArrow.Pickup.ALLOWED;
                        }
                        pLevel.addFreshEntity(dagger);
                        pLevel.playSound(null, dagger, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
                    }
                    if (!player.getAbilities().instabuild) {
                        player.getInventory().removeItem(stack);
                    }
                }
                player.awardStat(Stats.ITEM_USED.get(this));
            }
        }
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        if (slot == EquipmentSlot.MAINHAND){
            if (stack.is(ModItems.WOODEN_DAGGER.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(2));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-1));
                builder.build();
            }
            if (stack.is(ModItems.STONE_DAGGER.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(2.75));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-1));
                builder.build();
            }
            if (stack.is(ModItems.IRON_DAGGER.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(3.5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-1));
                builder.build();
            }
            if (stack.is(ModItems.GOLD_DAGGER.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(2));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-0));
                builder.build();
            }
            if (stack.is(ModItems.DIAMOND_DAGGER.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(4.25));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-0.5));
                builder.build();
            }
            if (stack.is(ModItems.NETHERITE_DAGGER.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-0.5));
                builder.build();
            }
        }
        return builder.build();
    }

    public AttributeModifier attributeDmg(double amountDmg){
        String attackDmg = Attributes.ATTACK_DAMAGE.getDescriptionId();
        return new AttributeModifier(attackDmg, amountDmg * 20, AttributeModifier.Operation.ADDITION);
    }
    public AttributeModifier attributeSpd(double amountSpd){
        String attackSpd = Attributes.ATTACK_SPEED.getDescriptionId();
        return new AttributeModifier(attackSpd, amountSpd * 20, AttributeModifier.Operation.ADDITION);
    }

    @Override
    public boolean canAttackBlock(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, Player pPlayer) {
        return !pPlayer.isCreative();
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack pStack, BlockState pState) {
        if (pState.is(Blocks.COBWEB)) {
            return 15.0F;
        } else {
            return 1.0F;
        }
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, Player pPlayer, @NotNull InteractionHand pHand) {
        ItemStack dagger = pPlayer.getItemInHand(pHand);
        pPlayer.startUsingItem(pHand);
        return InteractionResultHolder.success(dagger);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, @NotNull LivingEntity pTarget, @NotNull LivingEntity pAttacker) {
        pStack.hurtAndBreak(1, pAttacker, (player) -> player.broadcastBreakEvent(pAttacker.getUsedItemHand()));
        return true;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack pStack) {
        return UseAnim.SPEAR;
    }
}
