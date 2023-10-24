package net.barch.mm;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.barch.mm.Zucchini.ZUCCHINI;

public class MikesMiscellanea implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	public static final String NAMESPACE = "mm";

    public static final Logger LOGGER = LoggerFactory.getLogger("Mikes Miscellanea");

	public static final RegistryKey<ItemGroup> MIKES_MISCELLANEA_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(NAMESPACE, "mm"));


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Goodbye Fabric world!");

		Registry.register(Registries.ITEM_GROUP, MIKES_MISCELLANEA_GROUP, FabricItemGroup.builder()
				.icon(() -> new ItemStack(ZUCCHINI))
				.displayName(Text.translatable("itemGroup."+NAMESPACE+".mm"))
				.build());

		AllContent.RegisterAll();

	}


}