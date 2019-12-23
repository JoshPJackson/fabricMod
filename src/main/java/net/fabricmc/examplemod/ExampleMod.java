package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ExampleMod implements ModInitializer {
	public static final String MODID = "examplemod";
	
	// example block
	public static final Block EXAMPLE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).build());
		
		
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Example mod is active");
		this.register();
	}
	
	
	public void register()
	{
		Registry.register(Registry.BLOCK, new Identifier("examplemod", "example_block"), EXAMPLE_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("examplemod", "example_block"), new BlockItem(EXAMPLE_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
	}
}
