package net.kaicoyote.structuredcombat.item;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.entity.custom.entities.daggers.*;
import net.kaicoyote.structuredcombat.entity.custom.entities.hatchets.*;
import net.kaicoyote.structuredcombat.item.custom.DaggerItem;
import net.kaicoyote.structuredcombat.item.custom.HatchetItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    //Registry Methods
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, StructuredCombat.MOD_ID);
    public static Item basicItem(){
        return new Item(new Item.Properties());
    }

    //Mod Items
    public static RegistryObject<Item> DIAMOND_UPGRADE = ITEMS.register("diamond_upgrade", ModItems::basicItem);

    //Daggers
    public static RegistryObject<Item> WOODEN_DAGGER = ITEMS.register("wooden_dagger",
            ()-> new DaggerItem(WoodenDaggerProjectileEntity::new, new Item.Properties().durability(45)));

    public static RegistryObject<Item> STONE_DAGGER = ITEMS.register("stone_dagger",
            ()-> new DaggerItem(StoneDaggerProjectileEntity::new, new Item.Properties().durability(99)));

    public static RegistryObject<Item> IRON_DAGGER = ITEMS.register("iron_dagger",
            ()-> new DaggerItem(IronDaggerProjectileEntity::new, new Item.Properties().durability(188)));

    public static RegistryObject<Item> GOLD_DAGGER = ITEMS.register("gold_dagger",
            ()-> new DaggerItem(GoldDaggerProjectileEntity::new, new Item.Properties().durability(25)));

    public static RegistryObject<Item> DIAMOND_DAGGER = ITEMS.register("diamond_dagger",
            ()-> new DaggerItem(DiamondDaggerProjectileEntity::new, new Item.Properties().durability(1172)));

    public static RegistryObject<Item> NETHERITE_DAGGER = ITEMS.register("netherite_dagger",
            ()-> new DaggerItem(NetheriteDaggerProjectileEntity::new, new Item.Properties().durability(1523)));

    //Hatchets
    public static RegistryObject<Item> WOODEN_HATCHET = ITEMS.register("wooden_hatchet",
            ()-> new HatchetItem(WoodenHatchetProjectileEntity::new, new Item.Properties().durability(48)));
    public static RegistryObject<Item> STONE_HATCHET = ITEMS.register("stone_hatchet",
            ()-> new HatchetItem(StoneHatchetProjectileEntity::new, new Item.Properties().durability(105)));
    public static RegistryObject<Item> IRON_HATCHET = ITEMS.register("iron_hatchet",
            ()-> new HatchetItem(IronHatchetProjectileEntity::new, new Item.Properties().durability(200)));
    public static RegistryObject<Item> GOLD_HATCHET = ITEMS.register("gold_hatchet",
            ()-> new HatchetItem(GoldHatchetProjectileEntity::new, new Item.Properties().durability(26)));
    public static RegistryObject<Item> DIAMOND_HATCHET = ITEMS.register("diamond_hatchet",
            ()-> new HatchetItem(DiamondHatchetProjectileEntity::new, new Item.Properties().durability(1249)));
    public static RegistryObject<Item> NETHERITE_HATCHET = ITEMS.register("netherite_hatchet",
            ()-> new HatchetItem(NetheriteHatchetProjectileEntity::new, new Item.Properties().durability(1625)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
