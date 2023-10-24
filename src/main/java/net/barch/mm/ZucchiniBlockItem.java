package net.barch.mm;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import static net.barch.mm.Zucchini.ZUCCHINI;

public class ZucchiniBlockItem extends BlockItem {

    Random random = Random.create();

    public ZucchiniBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if (!(entity instanceof PlayerEntity)) {
            return;
        }
        if (random.nextBetween(0,100) != 0) {
            return;
        }
        ItemStack zuc = ZUCCHINI.getDefaultStack();
        zuc.setCount(stack.getCount());

        ((PlayerEntity)entity).getInventory().insertStack(zuc);

    }
}
