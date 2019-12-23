package net.fabricmc.examplemod.blocks;

import net.minecraft.fluid.BaseFluid;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.block.piston.PistonBehavior;

public class BaseFluidBlock extends FluidBlock {
	
	private static Material myMaterial = new Material(
            MaterialColor.GREEN,   //materialColor,
            true,   //isLiquid,
            false, // isSolid,
            true, // blocksMovement,
            false,// blocksLight,  <----- Important part, the other parts change as you wish
            true,//  !requiresTool,
            false, //  burnable,
            false,//  replaceable,
            PistonBehavior.NORMAL//  pistonBehavior
    );
	
	public BaseFluidBlock(BaseFluid fluid)
	{			
		super(fluid, Settings.of(myMaterial));
	}
}
