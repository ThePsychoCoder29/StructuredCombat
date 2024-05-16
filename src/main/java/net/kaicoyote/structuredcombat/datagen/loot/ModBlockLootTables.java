package net.kaicoyote.structuredcombat.datagen.loot;

import net.kaicoyote.structuredcombat.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
    }

    protected LootTable.Builder createMultipleResultItemDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                        this.applyExplosionDecay
                                (pBlock, LootItem.lootTableItem(item)
                                        .apply(SetItemCountFunction.setCount
                                                (UniformGenerator.between(2.0F, 5.0F)))
                                                    .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }
    protected LootTable.Builder createSingleResultItemDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                        this.applyExplosionDecay
                                (pBlock, LootItem.lootTableItem(item)
                                        .apply(SetItemCountFunction.setCount
                                                (UniformGenerator.between(1.0f, 1.0F)))));
    }
    protected LootTable.Builder createSingleResultBlockDrops(Block pBlock, Block block) {
        return createSilkTouchDispatchTable(pBlock,
                        this.applyExplosionDecay
                                (pBlock, LootItem.lootTableItem(block)
                                        .apply(SetItemCountFunction.setCount
                                                (UniformGenerator.between(1.0f, 1.0F)))));
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
