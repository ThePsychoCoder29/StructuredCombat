package net.kaicoyote.structuredcombat.item;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.entity.custom.entities.WoodenDaggerProjectileEntity;
import net.kaicoyote.structuredcombat.item.custom.DaggerItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, StructuredCombat.MOD_ID);
    public static RegistryObject<Item> WOODEN_DAGGER = ITEMS.register("wooden_dagger",
            ()-> new DaggerItem(new Item.Properties().durability(45)));
    public static RegistryObject<Item> STONE_DAGGER = ITEMS.register("stone_dagger",
            ()-> new DaggerItem(new Item.Properties().durability(99)));
    public static RegistryObject<Item> IRON_DAGGER = ITEMS.register("iron_dagger",
            ()-> new DaggerItem(new Item.Properties().durability(188)));
    public static RegistryObject<Item> GOLD_DAGGER = ITEMS.register("gold_dagger",
            ()-> new DaggerItem(new Item.Properties().durability(25)));
    public static RegistryObject<Item> DIAMOND_DAGGER = ITEMS.register("diamond_dagger",
            ()-> new DaggerItem(new Item.Properties().durability(1172)));
    public static RegistryObject<Item> NETHERITE_DAGGER = ITEMS.register("netherite_dagger",
            ()-> new DaggerItem(new Item.Properties().durability(1523)));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
