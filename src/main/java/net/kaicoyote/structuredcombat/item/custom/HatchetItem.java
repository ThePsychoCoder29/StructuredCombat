package net.kaicoyote.structuredcombat.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.kaicoyote.structuredcombat.entity.custom.entities.hatchets.HatchetProjectileEntity;
import net.kaicoyote.structuredcombat.item.ModItems;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.common.ToolActions;
import org.apache.commons.lang3.function.TriFunction;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

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
    public boolean hurtEnemy(ItemStack pStack, @NotNull LivingEntity pTarget, @NotNull LivingEntity pAttacker) {
        pStack.hurtAndBreak(1, pAttacker, (player) -> player.broadcastBreakEvent(pAttacker.getUsedItemHand()));
        return true;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack pStack) {
        return UseAnim.SPEAR;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        if (slot == EquipmentSlot.MAINHAND){
            if (stack.is(ModItems.WOODEN_HATCHET.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(5.5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3));
                builder.build();
            }
            if (stack.is(ModItems.STONE_HATCHET.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(7));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3));
                builder.build();
            }
            if (stack.is(ModItems.IRON_HATCHET.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(7));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-3));
                builder.build();
            }
            if (stack.is(ModItems.GOLD_HATCHET.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(5.5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-2.6));
                builder.build();
            }
            if (stack.is(ModItems.DIAMOND_HATCHET.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(7.5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-2.8));
                builder.build();
            }
            if (stack.is(ModItems.NETHERITE_HATCHET.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(8.5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-2.8));
                builder.build();
            }
        }
        return builder.build();
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
        if (pState.is(Blocks.COBWEB)) {
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
                        hatchet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.00264008859357777F, 1.0F);
                        if (player.getAbilities().instabuild) {
                            hatchet.pickup = AbstractArrow.Pickup.ALLOWED;
                        }
                        pLevel.addFreshEntity(hatchet);
                        pLevel.playSound(null, hatchet, SoundEvents.TRIDENT_THROW, SoundSource.PLAYERS, 1.0F, 1.0F);
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
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        Player player = pContext.getPlayer();
        BlockState blockstate = level.getBlockState(blockpos);
        Optional<BlockState> optional = Optional.ofNullable(blockstate.getToolModifiedState(pContext, ToolActions.AXE_STRIP, false));
        Optional<BlockState> optional1 = optional.isPresent() ? Optional.empty() : Optional.ofNullable(blockstate.getToolModifiedState(pContext, ToolActions.AXE_SCRAPE, false));
        Optional<BlockState> optional2 = optional.isEmpty() && optional1.isEmpty() ? Optional.ofNullable(blockstate.getToolModifiedState(pContext, ToolActions.AXE_WAX_OFF, false)) : Optional.empty();
        ItemStack itemstack = pContext.getItemInHand();
        Optional<BlockState> optional3 = Optional.empty();
        if (optional.isPresent()) {
            level.playSound(player, blockpos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            optional3 = optional;
        } else if (optional1.isPresent()) {
            level.playSound(player, blockpos, SoundEvents.AXE_SCRAPE, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.levelEvent(player, 3005, blockpos, 0);
            optional3 = optional1;
        } else if (optional2.isPresent()) {
            level.playSound(player, blockpos, SoundEvents.AXE_WAX_OFF, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.levelEvent(player, 3004, blockpos, 0);
            optional3 = optional2;
        }

        if (optional3.isPresent()) {
            if (player instanceof ServerPlayer) {
                CriteriaTriggers.ITEM_USED_ON_BLOCK.trigger((ServerPlayer)player, blockpos, itemstack);
            }

            level.setBlock(blockpos, optional3.get(), 11);
            level.gameEvent(GameEvent.BLOCK_CHANGE, blockpos, GameEvent.Context.of(player, optional3.get()));
            if (player != null) {
                itemstack.hurtAndBreak(1, player, (p_150686_) -> p_150686_.broadcastBreakEvent(pContext.getHand()));
            }

            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        else {
            return InteractionResult.PASS;
        }
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, Player pPlayer, @NotNull InteractionHand pHand) {
        ItemStack dagger = pPlayer.getItemInHand(pHand);
        pPlayer.startUsingItem(pHand);
        return InteractionResultHolder.success(dagger);
    }

}
