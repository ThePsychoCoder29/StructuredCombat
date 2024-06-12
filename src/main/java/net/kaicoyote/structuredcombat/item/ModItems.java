package net.kaicoyote.structuredcombat.item;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.entity.custom.entities.daggers.*;
import net.kaicoyote.structuredcombat.entity.custom.entities.hatchets.DiamondHatchetProjectileEntity;
import net.kaicoyote.structuredcombat.entity.custom.entities.hatchets.GoldHatchetProjectileEntity;
import net.kaicoyote.structuredcombat.entity.custom.entities.hatchets.IronHatchetProjectileEntity;
import net.kaicoyote.structuredcombat.entity.custom.entities.hatchets.NetheriteHatchetProjectileEntity;
import net.kaicoyote.structuredcombat.entity.custom.entities.hatchets.StoneHatchetProjectileEntity;
import net.kaicoyote.structuredcombat.entity.custom.entities.hatchets.WoodenHatchetProjectileEntity;
import net.kaicoyote.structuredcombat.entity.custom.entities.spears.*;
import net.kaicoyote.structuredcombat.item.custom.*;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    //Registry Methods
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, StructuredCombat.MOD_ID);

    //Mod Items
    public static RegistryObject<Item> DIAMOND_UPGRADE = ITEMS.register("diamond_upgrade",
            DiamondUpgradeItem::createDiamondUpgradeTemplate);
    public static RegistryObject<Item> STRUCTURED_COMBAT_LOGO = ITEMS.register("structured_combat_logo",
            ()-> new Item(new Item.Properties()));

    //Daggers
    public static RegistryObject<Item> WOODEN_DAGGER = ITEMS.register("wooden_dagger",
            ()-> new DaggerItem(ModToolTiers.WOODEN, WoodenDaggerProjectileEntity::new, new Item.Properties().durability(3)));

    public static RegistryObject<Item> STONE_DAGGER = ITEMS.register("stone_dagger",
            ()-> new DaggerItem(ModToolTiers.STONE, StoneDaggerProjectileEntity::new, new Item.Properties().durability(66)));

    public static RegistryObject<Item> IRON_DAGGER = ITEMS.register("iron_dagger",
            ()-> new DaggerItem(ModToolTiers.IRON, IronDaggerProjectileEntity::new, new Item.Properties().durability(125)));

    public static RegistryObject<Item> GOLD_DAGGER = ITEMS.register("gold_dagger",
            ()-> new DaggerItem(ModToolTiers.GOLD, GoldDaggerProjectileEntity::new, new Item.Properties().durability(16)));

    public static RegistryObject<Item> DIAMOND_DAGGER = ITEMS.register("diamond_dagger",
            ()-> new DaggerItem(ModToolTiers.DIAMOND, DiamondDaggerProjectileEntity::new, new Item.Properties().durability(781)));

    public static RegistryObject<Item> NETHERITE_DAGGER = ITEMS.register("netherite_dagger",
            ()-> new DaggerItem(ModToolTiers.NETHERITE, NetheriteDaggerProjectileEntity::new, new Item.Properties().durability(1016).fireResistant()));

    //Hatchets
    public static RegistryObject<Item> WOODEN_HATCHET = ITEMS.register("wooden_hatchet",
            ()-> new HatchetItem(ModToolTiers.WOODEN, WoodenHatchetProjectileEntity::new, new Item.Properties().durability(3)));

    public static RegistryObject<Item> STONE_HATCHET = ITEMS.register("stone_hatchet",
            ()-> new HatchetItem(ModToolTiers.STONE, StoneHatchetProjectileEntity::new, new Item.Properties().durability(66)));

    public static RegistryObject<Item> IRON_HATCHET = ITEMS.register("iron_hatchet",
            ()-> new HatchetItem(ModToolTiers.IRON, IronHatchetProjectileEntity::new, new Item.Properties().durability(125)));

    public static RegistryObject<Item> GOLD_HATCHET = ITEMS.register("gold_hatchet",
            ()-> new HatchetItem(ModToolTiers.GOLD, GoldHatchetProjectileEntity::new, new Item.Properties().durability(16)));

    public static RegistryObject<Item> DIAMOND_HATCHET = ITEMS.register("diamond_hatchet",
            ()-> new HatchetItem(ModToolTiers.DIAMOND, DiamondHatchetProjectileEntity::new, new Item.Properties().durability(781)));

    public static RegistryObject<Item> NETHERITE_HATCHET = ITEMS.register("netherite_hatchet",
            ()-> new HatchetItem(ModToolTiers.NETHERITE, NetheriteHatchetProjectileEntity::new, new Item.Properties().durability(1016).fireResistant()));

    //Katanas
    public static RegistryObject<Item> WOODEN_KATANA = ITEMS.register("wooden_katana",
            ()-> new KatanaItem(ModToolTiers.WOODEN, new Item.Properties().durability(15)));
    public static RegistryObject<Item> STONE_KATANA = ITEMS.register("stone_katana",
            ()-> new KatanaItem(ModToolTiers.STONE, new Item.Properties().durability(33)));
    public static RegistryObject<Item> IRON_KATANA = ITEMS.register("iron_katana",
            ()-> new KatanaItem(ModToolTiers.IRON, new Item.Properties().durability(63)));
    public static RegistryObject<Item> GOLD_KATANA = ITEMS.register("gold_katana",
            ()-> new KatanaItem(ModToolTiers.GOLD, new Item.Properties().durability(8)));
    public static RegistryObject<Item> DIAMOND_KATANA = ITEMS.register("diamond_katana",
            ()-> new KatanaItem(ModToolTiers.DIAMOND, new Item.Properties().durability(190)));
    public static RegistryObject<Item> NETHERITE_KATANA = ITEMS.register("netherite_katana",
            ()-> new KatanaItem(ModToolTiers.NETHERITE, new Item.Properties().durability(238).fireResistant()));

    //Sabres
    public static RegistryObject<Item> WOODEN_SABRE = ITEMS.register("wooden_sabre",
            ()-> new SabreItem(ModToolTiers.WOODEN, new Item.Properties().durability(59)));
    public static RegistryObject<Item> STONE_SABRE = ITEMS.register("stone_sabre",
            ()-> new SabreItem(ModToolTiers.STONE, new Item.Properties().durability(131)));
    public static RegistryObject<Item> IRON_SABRE = ITEMS.register("iron_sabre",
            ()-> new SabreItem(ModToolTiers.IRON, new Item.Properties().durability(250)));
    public static RegistryObject<Item> GOLD_SABRE = ITEMS.register("gold_sabre",
            ()-> new SabreItem(ModToolTiers.GOLD, new Item.Properties().durability(32)));
    public static RegistryObject<Item> DIAMOND_SABRE = ITEMS.register("diamond_sabre",
            ()-> new SabreItem(ModToolTiers.DIAMOND, new Item.Properties().durability(1561)));
    public static RegistryObject<Item> NETHERITE_SABRE = ITEMS.register("netherite_sabre",
            ()-> new SabreItem(ModToolTiers.NETHERITE, new Item.Properties().durability(2031).fireResistant()));

    //Spears
    public static RegistryObject<Item> WOODEN_SPEAR = ITEMS.register("wooden_spear",
            ()-> new SpearItem(ModToolTiers.WOODEN, WoodenSpearProjectileEntity::new, new Item.Properties().durability(89)));

    public static RegistryObject<Item> STONE_SPEAR = ITEMS.register("stone_spear",
            ()-> new SpearItem(ModToolTiers.STONE, StoneSpearProjectileEntity::new, new Item.Properties().durability(197)));

    public static RegistryObject<Item> IRON_SPEAR = ITEMS.register("iron_spear",
            ()-> new SpearItem(ModToolTiers.IRON, IronSpearProjectileEntity::new, new Item.Properties().durability(375)));

    public static RegistryObject<Item> GOLD_SPEAR = ITEMS.register("gold_spear",
            ()-> new SpearItem(ModToolTiers.GOLD, GoldSpearProjectileEntity::new, new Item.Properties().durability(48)));

    public static RegistryObject<Item> DIAMOND_SPEAR = ITEMS.register("diamond_spear",
            ()-> new SpearItem(ModToolTiers.DIAMOND, DiamondSpearProjectileEntity::new, new Item.Properties().durability(2342)));

    public static RegistryObject<Item> NETHERITE_SPEAR = ITEMS.register("netherite_spear",
            ()-> new SpearItem(ModToolTiers.NETHERITE, NetheriteSpearProjectileEntity::new, new Item.Properties().durability(3047).fireResistant()));

    //Longswords
    public static RegistryObject<Item> WOODEN_LONGSWORD = ITEMS.register("wooden_longsword",
            ()-> new LongswordItem(ModToolTiers.WOODEN, new Item.Properties().durability(89)));
    public static RegistryObject<Item> STONE_LONGSWORD = ITEMS.register("stone_longsword",
            ()-> new LongswordItem(ModToolTiers.STONE, new Item.Properties().durability(197)));
    public static RegistryObject<Item> IRON_LONGSWORD = ITEMS.register("iron_longsword",
            ()-> new LongswordItem(ModToolTiers.IRON, new Item.Properties().durability(375)));
    public static RegistryObject<Item> GOLD_LONGSWORD = ITEMS.register("gold_longsword",
            ()-> new LongswordItem(ModToolTiers.GOLD, new Item.Properties().durability(48)));
    public static RegistryObject<Item> DIAMOND_LONGSWORD = ITEMS.register("diamond_longsword",
            ()-> new LongswordItem(ModToolTiers.DIAMOND, new Item.Properties().durability(2342)));
    public static RegistryObject<Item> NETHERITE_LONGSWORD = ITEMS.register("netherite_longsword",
            ()-> new LongswordItem(ModToolTiers.NETHERITE, new Item.Properties().durability(3047).fireResistant()));

    //Scythes
    public static RegistryObject<Item> WOODEN_SCYTHE = ITEMS.register("wooden_scythe",
            ()-> new ScytheItem(ModToolTiers.WOODEN, new Item.Properties().durability(89)));
    public static RegistryObject<Item> STONE_SCYTHE = ITEMS.register("stone_scythe",
            ()-> new ScytheItem(ModToolTiers.STONE, new Item.Properties().durability(197)));
    public static RegistryObject<Item> IRON_SCYTHE = ITEMS.register("iron_scythe",
            ()-> new ScytheItem(ModToolTiers.IRON, new Item.Properties().durability(375)));
    public static RegistryObject<Item> GOLD_SCYTHE = ITEMS.register("gold_scythe",
            ()-> new ScytheItem(ModToolTiers.GOLD, new Item.Properties().durability(48)));
    public static RegistryObject<Item> DIAMOND_SCYTHE = ITEMS.register("diamond_scythe",
            ()-> new ScytheItem(ModToolTiers.DIAMOND, new Item.Properties().durability(2342)));
    public static RegistryObject<Item> NETHERITE_SCYTHE = ITEMS.register("netherite_scythe",
            ()-> new ScytheItem(ModToolTiers.NETHERITE, new Item.Properties().durability(3047).fireResistant()));

    //Lances
    public static RegistryObject<Item> WOODEN_LANCE = ITEMS.register("wooden_lance",
            ()-> new LanceItem(ModToolTiers.WOODEN, new Item.Properties().durability(89)));
    public static RegistryObject<Item> STONE_LANCE = ITEMS.register("stone_lance",
            ()-> new LanceItem(ModToolTiers.STONE, new Item.Properties().durability(197)));
    public static RegistryObject<Item> IRON_LANCE = ITEMS.register("iron_lance",
            ()-> new LanceItem(ModToolTiers.IRON, new Item.Properties().durability(375)));
    public static RegistryObject<Item> GOLD_LANCE = ITEMS.register("gold_lance",
            ()-> new LanceItem(ModToolTiers.GOLD, new Item.Properties().durability(48)));
    public static RegistryObject<Item> DIAMOND_LANCE = ITEMS.register("diamond_lance",
            ()-> new LanceItem(ModToolTiers.DIAMOND, new Item.Properties().durability(2342)));
    public static RegistryObject<Item> NETHERITE_LANCE = ITEMS.register("netherite_lance",
            ()-> new LanceItem(ModToolTiers.NETHERITE, new Item.Properties().durability(3047).fireResistant()));

    //Labyrs
    public static RegistryObject<Item> WOODEN_LABRYS = ITEMS.register("wooden_labrys",
            ()-> new LabrysItem(ModToolTiers.WOODEN, new Item.Properties().durability(89)));
    public static RegistryObject<Item> STONE_LABRYS = ITEMS.register("stone_labrys",
            ()-> new LabrysItem(ModToolTiers.STONE, new Item.Properties().durability(197)));
    public static RegistryObject<Item> IRON_LABRYS = ITEMS.register("iron_labrys",
            ()-> new LabrysItem(ModToolTiers.IRON, new Item.Properties().durability(375)));
    public static RegistryObject<Item> GOLD_LABRYS = ITEMS.register("gold_labrys",
            ()-> new LabrysItem(ModToolTiers.GOLD, new Item.Properties().durability(48)));
    public static RegistryObject<Item> DIAMOND_LABRYS = ITEMS.register("diamond_labrys",
            ()-> new LabrysItem(ModToolTiers.DIAMOND, new Item.Properties().durability(2342)));
    public static RegistryObject<Item> NETHERITE_LABRYS = ITEMS.register("netherite_labrys",
            ()-> new LabrysItem(ModToolTiers.NETHERITE, new Item.Properties().durability(3047).fireResistant()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
