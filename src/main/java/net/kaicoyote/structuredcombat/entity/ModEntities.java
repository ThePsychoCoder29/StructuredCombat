package net.kaicoyote.structuredcombat.entity;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.entity.custom.entities.daggers.*;
import net.kaicoyote.structuredcombat.entity.custom.entities.hatchets.*;
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

    public static RegistryObject<EntityType<WoodenHatchetProjectileEntity>> WOODEN_HATCHET =
            ENTITY_TYPES.register("wooden_hatchet" , ()-> EntityType.Builder.<WoodenHatchetProjectileEntity>of(WoodenHatchetProjectileEntity::new , MobCategory.MISC)
                    .sized(0.5f , 1.0f).build("wooden_hatchet"));
    public static RegistryObject<EntityType<StoneHatchetProjectileEntity>> STONE_HATCHET =
            ENTITY_TYPES.register("stone_hatchet" , ()-> EntityType.Builder.<StoneHatchetProjectileEntity>of(StoneHatchetProjectileEntity::new , MobCategory.MISC)
                    .sized(0.5f , 1.0f).build("stone_hatchet"));
    public static RegistryObject<EntityType<IronHatchetProjectileEntity>> IRON_HATCHET=
            ENTITY_TYPES.register("iron_hatchet" , ()-> EntityType.Builder.<IronHatchetProjectileEntity>of(IronHatchetProjectileEntity::new , MobCategory.MISC)
                    .sized(0.5f , 1.0f).build("iron_hatchet"));
    public static RegistryObject<EntityType<GoldHatchetProjectileEntity>> GOLD_HATCHET =
            ENTITY_TYPES.register("gold_hatchet" , ()-> EntityType.Builder.<GoldHatchetProjectileEntity>of(GoldHatchetProjectileEntity::new , MobCategory.MISC)
                    .sized(0.5f , 1.0f).build("gold_hatchet"));
    public static RegistryObject<EntityType<DiamondHatchetProjectileEntity>> DIAMOND_HATCHET =
            ENTITY_TYPES.register("diamond_hatchet" , ()-> EntityType.Builder.<DiamondHatchetProjectileEntity>of(DiamondHatchetProjectileEntity::new , MobCategory.MISC)
                    .sized(0.5f , 1.0f).build("diamond_hatchet"));
    public static RegistryObject<EntityType<NetheriteHatchetProjectileEntity>> NETHERITE_HATCHET =
            ENTITY_TYPES.register("netherite_hatchet" , ()-> EntityType.Builder.<NetheriteHatchetProjectileEntity>of(NetheriteHatchetProjectileEntity::new , MobCategory.MISC)
                    .sized(0.5f , 1.0f).build("netherite_hatchet"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
