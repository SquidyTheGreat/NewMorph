package icantafford.newmorph;

import net.fabricmc.api.ModInitializer;
import net.minecraft.component.DataComponentTypes;
// Minecraft imports
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
// The line `import net.minecraft.util.Identifier;` is importing the `Identifier` class from the
// Minecraft API. The `Identifier` class is used to uniquely identify resources within Minecraft, such
// as items, blocks, sounds, etc. It is commonly used to create unique identifiers for registering and
// referencing game content in mods.
import net.minecraft.util.Identifier;
import net.minecraft.util.Unit;

import java.util.function.Function;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;



public class NewMorph implements ModInitializer {
	public static final String MOD_ID = "new-morph";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final Item CUSTOM_ITEM = register("custom_item", CustomItem::new, new Item.Settings()
		.component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
		.maxCount(16));

	public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings){
			final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("tutorial", path));
			return Items.register(registryKey, factory,settings);
	}

	/** 
	Commented out just in case it complains -B
	public static void initialize(){

	}
	**/

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
	}
}