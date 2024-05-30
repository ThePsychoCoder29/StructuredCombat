package net.kaicoyote.structuredcombat.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DiamondUpgradeItem extends SmithingTemplateItem {
    //Empty Slots
    private static final ResourceLocation EMPTY_SLOT_DAGGER;
    private static final ResourceLocation EMPTY_SLOT_HATCHET;
    private static final ResourceLocation EMPTY_SLOT_KATANA;
    private static final ResourceLocation EMPTY_SLOT_SABRE;
    private static final ResourceLocation EMPTY_SLOT_DIAMOND;
    private static final ResourceLocation EMPTY_SLOT_SPEAR;
    private static final ResourceLocation EMPTY_SLOT_LONGSWORD;

    //Components
    private static final Component DIAMOND_UPGRADE;
    private static final Component APPLIES_TO_TITLE;
    private static final Component DIAMOND_UPGRADE_APPLIES_TO;
    private static final Component DIAMOND_UPGRADE_INGREDIENTS;
    private static final Component DIAMOND_UPGRADE_BASE_SLOT_DESCRIPTION;
    private static final Component DIAMOND_UPGRADE_ADDITIONS_SLOT_DESCRIPTION;
    private static final Component INGREDIENTS_TITLE;

    //Variables
    private final Component appliesTo;
    private final Component ingredients;
    private final Component upgradeDescription;

    public DiamondUpgradeItem(Component pAppliesTo, Component pIngredients, Component pUpgradeDescription, Component pBaseSlotDescription, Component pAdditionsSlotDescription, List<ResourceLocation> pBaseSlotEmptyIcons, List<ResourceLocation> pAdditionalSlotEmptyIcons) {
        super(pAppliesTo, pIngredients, pUpgradeDescription, pBaseSlotDescription, pAdditionsSlotDescription, pBaseSlotEmptyIcons, pAdditionalSlotEmptyIcons);
        this.appliesTo = pAppliesTo;
        this.ingredients = pIngredients;
        this.upgradeDescription = pUpgradeDescription;
    }

    public static SmithingTemplateItem createDiamondUpgradeTemplate(){
        return new SmithingTemplateItem(DIAMOND_UPGRADE_APPLIES_TO, DIAMOND_UPGRADE_INGREDIENTS, DIAMOND_UPGRADE, DIAMOND_UPGRADE_BASE_SLOT_DESCRIPTION, DIAMOND_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createDiamondUpgradeIconList(), createDiamondUpgradeMaterialList());

    }
    public static List<ResourceLocation> createDiamondUpgradeIconList() {
        return List.of(EMPTY_SLOT_DAGGER, EMPTY_SLOT_HATCHET, EMPTY_SLOT_KATANA, EMPTY_SLOT_SABRE, EMPTY_SLOT_SPEAR, EMPTY_SLOT_LONGSWORD);
    }

    public static List<ResourceLocation> createDiamondUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_DIAMOND);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, @NotNull List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
        pTooltipComponents.add(this.upgradeDescription);
        pTooltipComponents.add(CommonComponents.EMPTY);
        pTooltipComponents.add(APPLIES_TO_TITLE);
        pTooltipComponents.add(CommonComponents.space().append(this.appliesTo));
        pTooltipComponents.add(INGREDIENTS_TITLE);
        pTooltipComponents.add(CommonComponents.space().append(this.ingredients));
    }

    static{
        APPLIES_TO_TITLE = Component.translatable("item.structuredcombat.smithing_template.applies_to").withStyle(ChatFormatting.BLUE);
        INGREDIENTS_TITLE = Component.translatable("item.structuredcombat.smithing_template.ingredients").withStyle(ChatFormatting.BLUE);
        DIAMOND_UPGRADE = Component.translatable("upgrade.structuredcombat.diamond_upgrade");
        DIAMOND_UPGRADE_APPLIES_TO = Component.translatable("item.structuredcombat.smithing_template.diamond_upgrade.applies_to").withStyle(ChatFormatting.BLUE);
        DIAMOND_UPGRADE_INGREDIENTS = Component.translatable("item.structuredcombat.smithing_template.diamond_upgrade.ingredients").withStyle(ChatFormatting.BLUE);
        DIAMOND_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable("item.structuredcombat.smithing_template.diamond_upgrade.base_slot_description");
        DIAMOND_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable("item.structuredcombat.smithing_template.diamond_upgrade.additions_slot_description");
        EMPTY_SLOT_DIAMOND = new ResourceLocation("structuredcombat:item/empty_slot_diamond");
        EMPTY_SLOT_DAGGER = new ResourceLocation("structuredcombat:item/empty_slot_dagger");
        EMPTY_SLOT_HATCHET = new ResourceLocation("structuredcombat:item/empty_slot_hatchet");
        EMPTY_SLOT_KATANA = new ResourceLocation("structuredcombat:item/empty_slot_katana");
        EMPTY_SLOT_SABRE = new ResourceLocation("structuredcombat:item/empty_slot_sabre");
        EMPTY_SLOT_SPEAR = new ResourceLocation("structuredcombat:item/empty_slot_spear");
        EMPTY_SLOT_LONGSWORD = new ResourceLocation("structuredcombat:item/empty_slot_longsword");
    }
}
