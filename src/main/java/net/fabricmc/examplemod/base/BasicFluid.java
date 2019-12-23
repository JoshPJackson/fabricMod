package net.fabricmc.examplemod.base;

import net.minecraft.fluid.BaseFluid;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluid;
import net.minecraft.world.BlockView;
import net.minecraft.world.IWorld;
import net.minecraft.world.WorldView;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.Block;

public abstract class BasicFluid extends BaseFluid
{
	// does it produce infinite fluid (like water)
	@Override
	protected boolean isInfinite()
	{
		return false;
	}
	
	@Override
	public abstract Item getBucketItem();
	
	@Override
	protected abstract BlockState toBlockState(FluidState var1);
	
	@Override
	public abstract Fluid getFlowing();
	
	@Override
	public abstract Fluid getStill();
	
	@Override
	protected int getLevelDecreasePerBlock(WorldView world)
	{
		return 1;
	}
	
	@Override
	public int getTickRate(WorldView world)
	{
		return 5;
	}
	
	@Override
	protected int method_15733(WorldView world)
	{
		return 4;
	}
	
	// I don't know what this does, but it's present in the water fluid
    @Override
    protected void beforeBreakingBlock(IWorld world, BlockPos blockPos, BlockState blockState) {
        BlockEntity blockEntity = blockState.getBlock().hasBlockEntity() ? world.getBlockEntity(blockPos) : null;
        Block.dropStacks(blockState, world.getWorld(), blockPos, blockEntity);
    }
 
    // also don't know what it does
    public boolean method_15777(FluidState fluidState, BlockView blockView, BlockPos blockPos, Fluid fluid, Direction direction) {
        return direction == Direction.DOWN;
    }
 
    /**
     *
     * @return is given fluid instance of this fluid?
     */
    @Override
    public abstract boolean matchesType(Fluid fluid);
    
    protected float getBlastResistance()
    {
		return 500;
    }
}
	