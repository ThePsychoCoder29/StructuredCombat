package net.kaicoyote.structuredcombat.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.kaicoyote.structuredcombat.effect.ModEffects;
import net.kaicoyote.structuredcombat.effect.custom.BleedingEffect;
import net.kaicoyote.structuredcombat.item.ModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class ScytheItem extends SwordItem  {
    public static int oldAmplifier;

    public ScytheItem(Tier pTier, Properties pProperties) {
        super(pTier, 0, 0, pProperties);
    }

    @NotNull
    private static List<BlockPos> getBlockPos(BlockPos pos) {
        List<BlockPos> blockPosList = new ArrayList<>();
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        blockPosList.add(new BlockPos(x, y, z));
        blockPosList.add(new BlockPos(x + 1, y, z));
        blockPosList.add(new BlockPos(x - 1, y, z));
        blockPosList.add(new BlockPos(x, y, z + 1));
        blockPosList.add(new BlockPos(x, y, z - 1));
        blockPosList.add(new BlockPos(x + 1, y, z + 1));
        blockPosList.add(new BlockPos(x - 1, y, z - 1));
        blockPosList.add(new BlockPos(x - 1, y, z + 1));
        blockPosList.add(new BlockPos(x + 1, y, z - 1));
        return blockPosList;
    }

    @Override
    public boolean mineBlock(@NotNull ItemStack stack, @NotNull Level level, @NotNull BlockState state, @NotNull BlockPos pos, @NotNull LivingEntity pMiningEntity) {
        stack.hurtAndBreak(1, pMiningEntity, (user) -> user.broadcastBreakEvent(EquipmentSlot.MAINHAND));
        return true;
    }

    @Override
    public @NotNull InteractionResult useOn(@NotNull UseOnContext pContext) {
        Player player = pContext.getPlayer();
        Level level = pContext.getLevel();
        BlockPos pos = pContext.getClickedPos();
        BlockState state = level.getBlockState(pos);
        ItemStack stack = pContext.getItemInHand();
        assert player != null;
        if(!level.isClientSide() && player.isCrouching()) {
            if (state.is(BlockTags.CROPS)) {
                CropBlock block = (CropBlock) state.getBlock();
                int age = block.getAge(state);
                int maxAge = block.getMaxAge();
                if (age == maxAge) {
                    List<BlockPos> posList = getBlockPos(pos);
                    for (BlockPos blockPos : posList) {
                        BlockState blockState = level.getBlockState(blockPos);
                        if (blockState.is(BlockTags.CROPS)) {
                            CropBlock cropBlock = (CropBlock) blockState.getBlock();
                            int cropAge = cropBlock.getAge(blockState);
                            int cropMaxAge = cropBlock.getMaxAge();
                            if (cropAge == cropMaxAge) {
                                level.destroyBlock(blockPos,true, player);
                                stack.hurtAndBreak(1, player, user -> user.broadcastBreakEvent(player.getUsedItemHand()));
                            }
                        }
                    }
                }
            }
        }
        return InteractionResult.FAIL;
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        if (slot == EquipmentSlot.MAINHAND){
            if (stack.is(ModItems.WOODEN_SCYTHE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(4));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-2.5));
                builder.build();
            }
            if (stack.is(ModItems.STONE_SCYTHE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-2.5));
                builder.build();
            }
            if (stack.is(ModItems.IRON_SCYTHE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(6.5));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-2.5));
                builder.build();
            }
            if (stack.is(ModItems.GOLD_SCYTHE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(4));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-2));
                builder.build();
            }
            if (stack.is(ModItems.DIAMOND_SCYTHE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(7));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-2.2));
                builder.build();
            }
            if (stack.is(ModItems.NETHERITE_SCYTHE.get())) {
                builder.put(Attributes.ATTACK_DAMAGE, attributeDmg(9));
                builder.put(Attributes.ATTACK_SPEED, attributeSpd(-2.2));
                builder.build();
            }
        }

        return builder.build();
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
            pTooltipComponents.add(Component.translatable("tooltip.structuredcombat.scythe.tooltip"));
        }
        else {
            pTooltipComponents.add(Component.translatable("tooltip.structuredcombat.shift.tooltip"));
            super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        }
    }

    public static void setOldAmplifier(int amplifier){
        oldAmplifier = amplifier;
    }

    public static int getOldAmplifier() {
        return oldAmplifier;
    }

    public void applyBleeding(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker){
        if(pTarget.hasEffect(ModEffects.BLEEDING_EFFECT.get())){
            int oldAmplifier = Objects.requireNonNull(pTarget.getEffect(ModEffects.BLEEDING_EFFECT.get())).getAmplifier();
            setOldAmplifier(oldAmplifier);
        }
        InteractionHand hand = pAttacker.getUsedItemHand();
        MobEffect effect = ModEffects.BLEEDING_EFFECT.get();
        pStack.hurtAndBreak(1, pAttacker, (player) -> player.broadcastBreakEvent(hand));
        MobEffectInstance scytheEffect = new MobEffectInstance(ModEffects.BLEEDING_EFFECT.get(), 140, 1, false, false, true);
        pTarget.addEffect(scytheEffect);
        if(pTarget.hasEffect(effect)){
            MobEffectInstance bleedingEffect = pTarget.getEffect(effect);
            assert bleedingEffect != null;
            if((bleedingEffect).getAmplifier() > 0){
                int newAmplifier = bleedingEffect.getAmplifier();
                int oldAmplifier = getOldAmplifier();
                if(oldAmplifier < newAmplifier) {
                    int durationTick = BleedingEffect.returnTickDuration();
                    if(pStack.is(ModItems.WOODEN_SCYTHE.get()) || pStack.is(ModItems.STONE_SCYTHE.get())){
                        if(durationTick >= 18){
                            BleedingEffect.setTickDuration(durationTick - 2);
                        }
                    }
                    else if (pStack.is(ModItems.IRON_SCYTHE.get()) || pStack.is(ModItems.GOLD_SCYTHE.get())) {
                        if(durationTick >= 16){
                            BleedingEffect.setTickDuration(durationTick - 2);
                        }
                    }
                    else if (pStack.is(ModItems.DIAMOND_SCYTHE.get())) {
                        if(durationTick >= 14){
                            BleedingEffect.setTickDuration(durationTick - 2);
                        }
                    }
                    else if (pStack.is(ModItems.NETHERITE_SCYTHE.get())) {
                        if(durationTick >= 12){
                            BleedingEffect.setTickDuration(durationTick - 2);
                        }
                    }
                    pAttacker.sendSystemMessage(Component.literal(Objects.requireNonNull(pTarget.getEffect(ModEffects.BLEEDING_EFFECT.get())).getAmplifier() + " = amplifier and " + BleedingEffect.getTickDuration() + " = duration tick"));
                }
            }
        }
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack pStack, @NotNull LivingEntity pTarget, @NotNull LivingEntity pAttacker){
        applyBleeding(pStack, pTarget, pAttacker);
        return true;
    }

    @Override
    public boolean canPerformAction(@NotNull ItemStack stack, @NotNull ToolAction toolAction) {
        return ToolActions.DEFAULT_HOE_ACTIONS.contains(toolAction) || super.canPerformAction(stack, toolAction);
    }

    @Override
    public boolean canAttackBlock(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, Player pPlayer) {
        return !pPlayer.isCreative();
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
