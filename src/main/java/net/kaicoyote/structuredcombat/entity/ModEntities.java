package net.kaicoyote.structuredcombat.entity;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.entity.custom.entities.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, StructuredCombat.MOD_ID);

    public static RegistryObject<EntityType<WoodenDaggerProjectileEntity>> WOODEN_DAGGER =
            ENTITY_TYPES.register("wooden_dagger" , ()-> EntityType.Builder.<WoodenDaggerProjectileEntity>of(WoodenDaggerProjectileEntity::new , MobCategory.MISC)
                    .sized(0.5f , 1.0f).build("wooden_dagger"));
    public static RegistryObject<EntityType<StoneDaggerProjectileEntity>> STONE_DAGGER =
            ENTITY_TYPES.register("stone_dagger" , ()-> EntityType.Builder.<StoneDaggerProjectileEntity>of(StoneDaggerProjectileEntity::new , MobCategory.MISC)
                    .sized(0.5f , 1.0f).build("stone_dagger"));
    public static RegistryObject<EntityType<IronDaggerProjectileEntity>> IRON_DAGGER=
            ENTITY_TYPES.register("iron_dagger" , ()-> EntityType.Builder.<IronDaggerProjectileEntity>of(IronDaggerProjectileEntity::new , MobCategory.MISC)
                    .sized(0.5f , 1.0f).build("iron_dagger"));
    public static RegistryObject<EntityType<GoldDaggerProjectileEntity>> GOLD_DAGGER =
            ENTITY_TYPES.register("gold_dagger" , ()-> EntityType.Builder.<GoldDaggerProjectileEntity>of(GoldDaggerProjectileEntity::new , MobCategory.MISC)
                    .sized(0.5f , 1.0f).build("gold_dagger"));
    public static RegistryObject<EntityType<DiamondDaggerProjectileEntity>> DIAMOND_DAGGER =
            ENTITY_TYPES.register("diamond_dagger" , ()-> EntityType.Builder.<DiamondDaggerProjectileEntity>of(DiamondDaggerProjectileEntity::new , MobCategory.MISC)
                    .sized(0.5f , 1.0f).build("diamond_dagger"));
    public static RegistryObject<EntityType<NetheriteDaggerProjectileEntity>> NETHERITE_DAGGER =
            ENTITY_TYPES.register("netherite_dagger" , ()-> EntityType.Builder.<NetheriteDaggerProjectileEntity>of(NetheriteDaggerProjectileEntity::new , MobCategory.MISC)
                    .sized(0.5f , 1.0f).build("netherite_dagger"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
