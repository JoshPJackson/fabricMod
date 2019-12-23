package net.fabricmc.examplemod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.metadata.Side;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.impl.client.texture.FabricSprite;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;

public class ClientInitializer implements ClientModInitializer {
	
	 @Override
    public void onInitializeClient()
    {
		 System.out.println("client initializer called");
        // adding the sprites to the block texture atlas
        ClientSpriteRegistryCallback.event(SpriteAtlasTexture.BLOCK_ATLAS_TEX).register((spriteAtlasTexture, registry) -> {
 
            Identifier stillSpriteLocation = new Identifier("block/acid_still");
            Identifier dynamicSpriteLocation = new Identifier("block/acid_flowing");
            // here I tell to use only 16x16 area of the water texture
            FabricSprite stillAcidSprite = new FabricSprite(new SpriteAtlasTexture(stillSpriteLocation), null, 16, 16, 0, 0, 0, null);
            // same, but 32
            FabricSprite dynamicAcidSprite = new FabricSprite(new SpriteAtlasTexture(dynamicSpriteLocation), null, 32, 32, 0, 0, 0, null);
 
            registry.register(stillAcidSprite);
            registry.register(dynamicAcidSprite);
 
 
            // this renderer is responsible for drawing fluids in a world
            FluidRenderHandler acidRenderHandler = new FluidRenderHandler()
            {
                // return the sprites: still sprite goes first into the array, flowing/dynamic goes last
                @Override
                public Sprite[] getFluidSprites(BlockRenderView extendedBlockView, BlockPos blockPos, FluidState fluidState)
                {
                    return new Sprite[] {stillAcidSprite, dynamicAcidSprite};
                }
 
                // apply light green color
                @Override
                public int getFluidColor(BlockRenderView view, BlockPos pos, FluidState state)
                {
                    return 0x4cc248;
                }
            };
 
            // registering the same renderer for both fluid variants is intentional
 
            FluidRenderHandlerRegistry.INSTANCE.register(ExampleMod.stillAcid, acidRenderHandler);
            FluidRenderHandlerRegistry.INSTANCE.register(ExampleMod.flowingAcid, acidRenderHandler);
        });
    }
}
