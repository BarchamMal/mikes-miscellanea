package net.barch.mm;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.math.BlockPos;

import static net.barch.mm.Zucchini.ZUCCHINI_BLOCK;
import static net.barch.mm.Zucchini.ZUCCHINI_BLOCK_ITEM;
import static net.barch.mm.MikesMiscellanea.LOGGER;

public class MikesMiscellaneaClient implements ClientModInitializer {



	@Override
	public void onInitializeClient() {

		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ZUCCHINI_BLOCK);

		ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BiomeColors.getFoliageColor(view, pos), ZUCCHINI_BLOCK);

		ColorProviderRegistry.ITEM.register((stack, tintIndex) -> 0x90bb63,
				ZUCCHINI_BLOCK_ITEM);

	}
}