package net.barch.mm;

import net.barch.mm.Glue.BlockBuilder;
import net.barch.mm.Glue.ItemGrouped;
import net.barch.mm.Glue.ItemGrouper;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerBlock;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.barch.mm.MikesMiscellanea.NAMESPACE;

public class Zucchini extends Content {

    public static final FoodComponent ZUCCHINI_FOOD_COMPONENT = new FoodComponent
            .Builder()
            .alwaysEdible()
            .hunger(2)
            .snack()
            .saturationModifier(2)
            .statusEffect(
                    new StatusEffectInstance(
                            StatusEffects.LUCK,
                            10*20,
                            3
                    ),
            0.1f
            )
            .build();

    public static final Block ZUCCHINI_BLOCK = new FlowerBlock(StatusEffects.HEALTH_BOOST, 3, BlockBuilder.CloneBlock(Blocks.POPPY).nonOpaque().notSolid());

    public static final BlockItem ZUCCHINI_BLOCK_ITEM = new ZucchiniBlockItem(ZUCCHINI_BLOCK, new FabricItemSettings());

    public static final Item ZUCCHINI = new Item(new FabricItemSettings().food(ZUCCHINI_FOOD_COMPONENT));


    public static void RegisterBlocks() {

        Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "zucchini_block"), ZUCCHINI_BLOCK);

    }

    public static void RegisterItems() {

        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "zucchini_block"), ZUCCHINI_BLOCK_ITEM);
        Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "zucchini"), ZUCCHINI);

    }

    public static void GroupItems() {

         ItemGrouper.GroupItem(ZUCCHINI, new ItemGrouped[]{new ItemGrouped(ItemGroups.FOOD_AND_DRINK, ZUCCHINI)});
        ItemGrouper.GroupItem(ZUCCHINI_BLOCK_ITEM, new ItemGrouped[]{new ItemGrouped(ItemGroups.TOOLS, ZUCCHINI)});

    }

    public static void RegisterAll() {
        RegisterBlocks();
        RegisterItems();
        GroupItems();
    }


}
