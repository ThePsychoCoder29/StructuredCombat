package net.kaicoyote.structuredcombat.mixin;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.SmithingTemplateItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Unique;
import java.util.List;

@Mixin(SmithingTemplateItem.class)
public class NetheriteUpgradeSmithingTemplateIconListMixin {
    @Unique
    private static final ResourceLocation EMPTY_SLOT_HELMET;
    @Unique
    private static final ResourceLocation EMPTY_SLOT_CHESTPLATE;
    @Unique
    private static final ResourceLocation EMPTY_SLOT_LEGGINGS;
    @Unique
    private static final ResourceLocation EMPTY_SLOT_BOOTS;
    @Unique
    private static final ResourceLocation EMPTY_SLOT_HOE;
    @Unique
    private static final ResourceLocation EMPTY_SLOT_AXE;
    @Unique
    private static final ResourceLocation EMPTY_SLOT_SWORD;
    @Unique
    private static final ResourceLocation EMPTY_SLOT_SHOVEL;
    @Unique
    private static final ResourceLocation EMPTY_SLOT_PICKAXE;
    @Unique
    private static final ResourceLocation EMPTY_SLOT_DAGGER;
    @Unique
    private static final ResourceLocation EMPTY_SLOT_HATCHET;
    @Unique
    private static final ResourceLocation EMPTY_SLOT_KATANA;
    @Unique
    private static final ResourceLocation EMPTY_SLOT_SABRE;
    @Unique
    private static final ResourceLocation EMPTY_SLOT_SPEAR;
    @Unique
    private static final ResourceLocation EMPTY_SLOT_LONGSWORD;
    @Unique
    private static final ResourceLocation EMPTY_SLOT_SCYTHE;
    @Unique
    private static final ResourceLocation EMPTY_SLOT_LANCE;

    /**
     * @author MrMisc29 / KaiCoyote
     * @reason To add Structured Combat Weapon Icons to the createNetheriteUpgradeIconList of SmithingTemplateItem
     */
    @Overwrite
    public static List<ResourceLocation> createNetheriteUpgradeIconList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_BOOTS,
                EMPTY_SLOT_HOE, EMPTY_SLOT_AXE, EMPTY_SLOT_SWORD, EMPTY_SLOT_SHOVEL, EMPTY_SLOT_PICKAXE,
                EMPTY_SLOT_DAGGER, EMPTY_SLOT_HATCHET, EMPTY_SLOT_KATANA, EMPTY_SLOT_SABRE, EMPTY_SLOT_SPEAR,
                EMPTY_SLOT_LONGSWORD, EMPTY_SLOT_SCYTHE, EMPTY_SLOT_LANCE);
    }

    static {
        EMPTY_SLOT_HELMET = new ResourceLocation("item/empty_armor_slot_helmet");
        EMPTY_SLOT_CHESTPLATE = new ResourceLocation("item/empty_armor_slot_chestplate");
        EMPTY_SLOT_LEGGINGS = new ResourceLocation("item/empty_armor_slot_leggings");
        EMPTY_SLOT_BOOTS = new ResourceLocation("item/empty_armor_slot_boots");
        EMPTY_SLOT_HOE = new ResourceLocation("item/empty_slot_hoe");
        EMPTY_SLOT_AXE = new ResourceLocation("item/empty_slot_axe");
        EMPTY_SLOT_SWORD = new ResourceLocation("item/empty_slot_sword");
        EMPTY_SLOT_SHOVEL = new ResourceLocation("item/empty_slot_shovel");
        EMPTY_SLOT_PICKAXE = new ResourceLocation("item/empty_slot_pickaxe");
        EMPTY_SLOT_DAGGER = new ResourceLocation("structuredcombat:item/empty_slot_dagger");
        EMPTY_SLOT_HATCHET = new ResourceLocation("structuredcombat:item/empty_slot_hatchet");
        EMPTY_SLOT_KATANA = new ResourceLocation("structuredcombat:item/empty_slot_katana");
        EMPTY_SLOT_SABRE = new ResourceLocation("structuredcombat:item/empty_slot_sabre");
        EMPTY_SLOT_SPEAR = new ResourceLocation("structuredcombat:item/empty_slot_spear");
        EMPTY_SLOT_LONGSWORD = new ResourceLocation("structuredcombat:item/empty_slot_longsword");
        EMPTY_SLOT_SCYTHE = new ResourceLocation("structuredcombat:item/empty_slot_scythe");
        EMPTY_SLOT_LANCE = new ResourceLocation("structuredcombat:item/empty_slot_lance");
    }
}
