package icantafford.newmorph;

import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
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
public final class TutorialItems {
    
	public static final Item CUSTOM_ITEM = register("custom_item", CustomItem::new, new Item.Settings()
		.component(DataComponentTypes.UNBREAKABLE, Unit.INSTANCE)
		.maxCount(16));

	public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings){
			final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("tutorial", path));
			return Items.register(registryKey, factory,settings);
	}

    public static void registerFuels() {
        FuelRegistryEvents.BUILD.register((builder, context) -> {
            builder.add(CUSTOM_ITEM, 200); // Custom item burns for 200 ticks
        });
    }
}
