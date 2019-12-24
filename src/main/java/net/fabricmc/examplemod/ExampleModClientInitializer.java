package net.fabricmc.examplemod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.examplemod.blocks.BaseFluidBlock;
import net.fabricmc.examplemod.client.FluidResourceLoader;
import net.fabricmc.examplemod.register.FluidRegistry;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;


public class ExampleModClientInitializer implements ClientModInitializer {
	
	@Override
	public void onInitializeClient() {
		ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES).registerReloadListener(new FluidResourceLoader());
		
		BlockRenderLayerMap.INSTANCE.putBlock(new BaseFluidBlock(FluidRegistry.STILL_ACID), RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putFluid(FluidRegistry.STILL_ACID, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putFluid(FluidRegistry.FLOWING_ACID, RenderLayer.getTranslucent());
		
		ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEX).register((texture, registry) -> {
			registry.register(new Identifier("examplemod", "block/acid_still"));
		});
	}
}
