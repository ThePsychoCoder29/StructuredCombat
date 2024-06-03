package net.kaicoyote.structuredcombat.enchantment;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.enchantment.custom.enchantments.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS =
            DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, StructuredCombat.MOD_ID);
    public static final RegistryObject<Enchantment> CHAINING = ENCHANTMENTS.register("chaining",
            ()-> new ChainingEnchantment(Enchantment.Rarity.COMMON, EnchantmentCategory.BREAKABLE, EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND));
    public static final RegistryObject<Enchantment> EAGLE_EYES = ENCHANTMENTS.register("eagle_eyes",
            ()-> new EagleEyesEnchantment(Enchantment.Rarity.COMMON, EnchantmentCategory.BOW, EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND));
    public static final RegistryObject<Enchantment> RECALL = ENCHANTMENTS.register("recall",
            ()-> new RecallEnchantment(Enchantment.Rarity.COMMON, EnchantmentCategory.BREAKABLE, EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND));
    public static final RegistryObject<Enchantment> PARALYZED = ENCHANTMENTS.register("paralyzed",
            ()-> new ParalyzedEnchantment(Enchantment.Rarity.COMMON, EnchantmentCategory.BREAKABLE, EquipmentSlot.MAINHAND));
    public static final RegistryObject<Enchantment> REIMBURSEMENT = ENCHANTMENTS.register("reimbursement",
            ()-> new ReimbursementEnchantment(Enchantment.Rarity.COMMON, EnchantmentCategory.BOW, EquipmentSlot.MAINHAND));

    public static void register(IEventBus eventBus){
        ENCHANTMENTS.register(eventBus);
    }
}