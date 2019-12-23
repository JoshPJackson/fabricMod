package net.fabricmc.examplemod.fluids;

import net.fabricmc.examplemod.ExampleMod;
import net.fabricmc.examplemod.base.BasicFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.block.FluidBlock;

public abstract class Acid extends BasicFluid {
	
	@Override
	public Item getBucketItem()
	{
		return ExampleMod.acidBucket;
	}
	
	@Override
	protected BlockState toBlockState(FluidState fluidState)
	{
	    return ExampleMod.acid.getDefaultState().with(FluidBlock.LEVEL, method_15741(fluidState));
	}
	
	@Override
	public Fluid getFlowing()
	{
		return ExampleMod.flowingAcid;
	}
	
	@Override
	public Fluid getStill()
	{
		return ExampleMod.stillAcid;
	}
	
	
	
	@Override
	public boolean matchesType(Fluid fluid_1)
	{
		return fluid_1 == ExampleMod.flowingAcid || fluid_1 == ExampleMod.stillAcid;
	}
	
	// still acid
    public static class Still extends Acid
    {
 
        @Override
        public boolean isStill(FluidState fluidState)
        {
            return true;
        }
 
        /**
         * @return height of the fluid block
         */
        @Override
        public int getLevel(FluidState fluidState)
        {
            return 8;
        }
    }
 
    // flowing acid
    public static class Flowing extends  Acid
    {
 
        @Override
        public boolean isStill(FluidState fluidState)
        {
            return false;
        }
 
        /**
         * @return height of the fluid block
         */
        @Override
        public int getLevel(FluidState fluidState)
        {
            return fluidState.get(LEVEL);
        }
 
        @Override
        protected void appendProperties(Builder<Fluid, FluidState> stateFactoryBuilder)
        {
            super.appendProperties(stateFactoryBuilder);
            stateFactoryBuilder.add(LEVEL);
        }
    }
}
