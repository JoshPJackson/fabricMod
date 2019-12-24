package net.fabricmc.examplemod.client;

import java.util.Arrays;
import java.util.Collection;

import net.fabricmc.examplemod.register.FluidRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.resource.ResourceReloadListenerKeys;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

public class FluidResourceLoader implements SimpleSynchronousResourceReloadListener{
	
	@Override
	public Identifier getFabricId() {
		return new Identifier("examplemod", "fluid_resource_loader");
	}
	
	@Override
	public Collection<Identifier> getFabricDependencies() {
		return Arrays.asList(ResourceReloadListenerKeys.MODELS, ResourceReloadListenerKeys.TEXTURES);
	}
	
	@Override
	public void apply(ResourceManager resourceManager)
	{
		FluidRenderHandler acidRenderHandler = (blockRenderView, blockPos, fluidState) -> 
			new Sprite[] {
				MinecraftClient.getInstance().getSpriteAtlas(SpriteAtlasTexture.BLOCK_ATLAS_TEX).apply(new Identifier("examplemod", "block/acid_still")),
				MinecraftClient.getInstance().getSpriteAtlas(SpriteAtlasTexture.BLOCK_ATLAS_TEX).apply(new Identifier("examplemod", "block/acid_flowing"))
			};
			
			FluidRenderHandlerRegistry.INSTANCE.register(FluidRegistry.STILL_ACID, acidRenderHandler);
			FluidRenderHandlerRegistry.INSTANCE.register(FluidRegistry.FLOWING_ACID, acidRenderHandler);
	}
}
