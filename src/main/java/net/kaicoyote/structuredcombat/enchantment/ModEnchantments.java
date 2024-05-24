package net.kaicoyote.structuredcombat.enchantment;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.enchantment.custom.ChainingEnchantment;
import net.kaicoyote.structuredcombat.enchantment.custom.EagleEyesEnchantment;
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
            ()-> new ChainingEnchantment(Enchantment.Rarity.COMMON, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND));
    public static final RegistryObject<Enchantment> EAGLE_EYES = ENCHANTMENTS.register("eagle_eyes",
            ()-> new EagleEyesEnchantment(Enchantment.Rarity.COMMON, EnchantmentCategory.BOW, EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND));

    public static void register(IEventBus eventBus){
        ENCHANTMENTS.register(eventBus);
    }
}
