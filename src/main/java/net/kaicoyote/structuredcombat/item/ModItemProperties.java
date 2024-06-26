package net.kaicoyote.structuredcombat.item;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItemProperties {
    public static void addCustomItemProperties(){
        makeShield(ModItems.WOODEN_SABRE.get());
        makeShield(ModItems.STONE_SABRE.get());
        makeShield(ModItems.IRON_SABRE.get());
        makeShield(ModItems.GOLD_SABRE.get());
        makeShield(ModItems.DIAMOND_SABRE.get());
        makeShield(ModItems.NETHERITE_SABRE.get());
    }
    
    public static void makeShield(Item item){
        ItemProperties.register(item, new ResourceLocation("blocking"), (stack, level, player, number) -> player != null && player.isUsingItem() && player.getUseItem() == stack ? 1.0F : 0.0F);
    }
}
