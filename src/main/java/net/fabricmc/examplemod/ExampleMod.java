package net.fabricmc.examplemod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.fabricmc.examplemod.blocks.BaseFluidBlock;
import net.minecraft.item.BucketItem;
import net.minecraft.block.FluidBlock;
import net.fabricmc.examplemod.register.FluidRegistry;

public class ExampleMod implements ModInitializer {
	public static final String MODID = "examplemod";
	
	// example block
	public static final Block EXAMPLE_BLOCK = new Block(FabricBlockSettings.of(Material.METAL).build());
	
	public static FluidBlock acid;
	
	public static BucketItem acidBucket;
		
	@Override
	public void onInitialize() {
		System.out.println("Example mod is active");
		this.register();
		FluidRegistry.init();
	}
	
	
	public void register()
	{
		Registry.register(Registry.BLOCK, new Identifier("examplemod", "example_block"), EXAMPLE_BLOCK);
		Registry.register(Registry.ITEM, new Identifier("examplemod", "example_block"), new BlockItem(EXAMPLE_BLOCK, new Item.Settings().group(ItemGroup.MISC)));
		
        BucketItem acidBucket = new BucketItem(FluidRegistry.STILL_ACID, new Item.Settings().maxCount(1).group(ItemGroup.MISC));
        Registry.register(Registry.ITEM, new Identifier("examplemod:acid_bucket"), acidBucket);
        
        acid = new BaseFluidBlock(FluidRegistry.STILL_ACID);
        Registry.register(Registry.BLOCK, new Identifier("examplemod:acid_block"), acid);
   
	}
}
