package net.kaicoyote.structuredcombat.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.kaicoyote.structuredcombat.entity.custom.entities.hatchets.HatchetProjectileEntity;
import net.kaicoyote.structuredcombat.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow.Pickup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.apache.commons.lang3.function.TriFunction;
import org.jetbrains.annotations.NotNull;

public class HatchetItem extends Item {
    private final TriFunction<Level, Player, ItemStack, HatchetProjectileEntity> constructor;
    public HatchetItem(TriFunction<Level, Player, ItemStack, HatchetProjectileEntity> constructor, Properties pProperties) {
        super(pProperties);
        this.constructor = constructor;
    }

    @Override
    public int getUseDuration(@NotNull ItemStack pStack) {
        return 72000;
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, @NotNull LivingEntity pTarget, @NotNull LivingEntity pAttacker){
        InteractionHand hand = pAttacker.getUsedItemHand();
        pStack.hurtAndBreak(1, pAttacker, (player) -> player.broadcastBreakEvent(hand));
        return true;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack pStack) {
        return UseAnim.SPEAR;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        if (slot == EquipmentSlot.MAINHAND) {
            attributeBuilder(builder, stack, ModItems.WOODEN_HATCHET.get(), 5.5, -3);
            attributeBuilder(builder, stack, ModItems.STONE_HATCHET.get(), 7, -3);
            attributeBuilder(builder, stack, ModItems.IRON_HATCHET.get(), 7, -3);
            attributeBuilder(builder, stack, ModItems.GOLD_HATCHET.get(), 5.5, -2.6);
            attributeBuilder(builder, stack, ModItems.DIAMOND_HATCHET.get(), 7.5, -2.8);
            attributeBuilder(builder, stack, ModItems.NETHERITE_HATCHET.get(), 8.5, -2.8);
        }
        return builder.build();
    }

    public void attributeBuilder(ImmutableMultimap.Builder<Attribute, AttributeModifier> builder, ItemStack stack, Item item ,double dmg, double spd){
        if(stack.is(item)){
            builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(dmg));
            builder.put(Attributes.ATTACK_SPEED, attributeSpd(spd));
            builder.build();
        }
    }
    public AttributeModifier attributeDmg(double amountDmg){
        return new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", amountDmg, AttributeModifier.Operation.ADDITION);
    }
    public AttributeModifier attributeSpd(double amountSpd){
        return new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", amountSpd, AttributeModifier.Operation.ADDITION);
    }

    @Override
    public boolean canAttackBlock(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, Player pPlayer) {
        return !pPlayer.isCreative();
    }

    @Override
    public float getDestroySpeed(@NotNull ItemStack pStack, BlockState pState) {
        if (pState.is(BlockTags.MINEABLE_WITH_AXE)) {
            return 15.0F;
        } else {
            return 1.0F;
        }
    }

    @Override
    public void releaseUsing(@NotNull ItemStack stack, @NotNull Level pLevel, @NotNull LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof Player player) {
            int duration = this.getUseDuration(stack) - pTimeLeft;
            if (duration >= 10) {
                if (!pLevel.isClientSide()) {
                    stack.hurtAndBreak(1, player, (broadcastPlayer) -> broadcastPlayer.broadcastBreakEvent(pEntityLiving.getUsedItemHand()));
                    if(stack.is(this)){
                        HatchetProjectileEntity hatchet = this.constructor.apply(pLevel, player, stack);
                        hatchet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.125F, 1.0F);
                        if (player.getAbilities().instabuild) {
                            hatchet.pickup = Pickup.CREATIVE_ONLY;
                        }
                        pLevel.addFreshEntity(hatchet);
                        pLevel.playSound(null, hatchet, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
                    }
                    if (player.getAbilities().instabuild) {
                        player.getInventory().removeItem(stack);
                    }
                }
                player.awardStat(Stats.ITEM_USED.get(this));
            }
        }
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, Player pPlayer, @NotNull InteractionHand pHand) {
        ItemStack hatchet = pPlayer.getItemInHand(pHand);
        pPlayer.startUsingItem(pHand);
        return InteractionResultHolder.success(hatchet);
    }

    @Override
    public boolean isEnchantable(@NotNull ItemStack pStack) {
        return true;
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return true;
    }
}
