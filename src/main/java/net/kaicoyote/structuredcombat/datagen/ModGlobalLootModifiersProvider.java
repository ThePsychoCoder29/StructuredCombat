package net.kaicoyote.structuredcombat.datagen;

import net.kaicoyote.structuredcombat.StructuredCombat;
import net.kaicoyote.structuredcombat.item.ModItems;
import net.kaicoyote.structuredcombat.loot.ModStructureLootModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, StructuredCombat.MOD_ID);
    }

    @Override
    protected void start() {
        //Structures
        add("iron_dagger_from_mineshaft", structureLIC("abandoned_mineshaft", ModItems.IRON_DAGGER.get()));
        add("iron_katana_from_jungle_temple", structureLIC("jungle_temple", ModItems.IRON_KATANA.get()));
        add("iron_sabre_from_shipwrecks_supply", structureLIC("shipwreck_supply", ModItems.IRON_SABRE.get()));
        add("iron_sabre_from_shipwrecks_treasure", structureLIC("shipwreck_treasure", ModItems.IRON_SABRE.get()));
        add("iron_sabre_from_buried_treasure", structureLIC("buried_treasure", ModItems.IRON_SABRE.get()));
        add("iron_longsword_from_woodland_mansion", structureLIC("woodland_mansion", ModItems.IRON_LONGSWORD.get()));

        //Villages
        add("iron_hatchet_from_snowy_villages", villageLIC("snowy_house", ModItems.IRON_HATCHET.get()));
        add("iron_spear_from_savanna_villages", villageLIC("savanna_house", ModItems.IRON_SPEAR.get()));
        add("iron_scythe_from_snowy_villages", villageLIC("plains_house", ModItems.IRON_SCYTHE.get()));
        add("iron_lance_from_taiga_villages", villageLIC("taiga_house", ModItems.IRON_LANCE.get()));

        //Bastions
        add("iron_labrys_from_bridge_bastion", bastionLIC("bridge", ModItems.IRON_LABRYS.get()));
        add("iron_labrys_from_hoglin_stable_bastion", bastionLIC("hoglin_stable", ModItems.IRON_LABRYS.get()));
        add("iron_labrys_from_other_bastion", bastionLIC("other", ModItems.IRON_LABRYS.get()));
        add("iron_labrys_from_treasure_bastion", bastionLIC("treasure", ModItems.IRON_LABRYS.get()));

        //Trail Ruins
        add("diamond_upgrade_from_treasure_bastion", trailRuinsLIC("trail_ruins_rare", ModItems.DIAMOND_UPGRADE.get()));

        //Reimbursement

    }

    public static ModStructureLootModifier structureLIC(String chestLoc, Item item){
        return new ModStructureLootModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/" + chestLoc)).build()
        }, item);
    }

    public static ModStructureLootModifier villageLIC(String chestLoc, Item item){
        return new ModStructureLootModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_" + chestLoc)).build()
        }, item);
    }
    public static ModStructureLootModifier bastionLIC(String chestLoc, Item item){
        return new ModStructureLootModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("chests/bastion_" + chestLoc)).build()
        }, item);
    }

    public static ModStructureLootModifier trailRuinsLIC(String chestLoc, Item item){
        return new ModStructureLootModifier(new LootItemCondition[]{
                new LootTableIdCondition.Builder(new ResourceLocation("archaeology/" + chestLoc)).build()
        }, item);
    }
}
