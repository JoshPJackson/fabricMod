package net.fabricmc.examplemod.register;

import net.fabricmc.examplemod.fluids.Acid;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class FluidRegistry {

	
	public static final Acid FLOWING_ACID = (Acid) register("acid_flowing", new Acid.Flowing());
	public static final Acid STILL_ACID = (Acid) register("acid_still", new Acid.Still());
	
	private FluidRegistry() {
		
	}
	
	private static Fluid register(String name, Fluid fluid) {
		return Registry.register(Registry.FLUID, new Identifier("examplemod", name), fluid);
	}
	
	public static void init() {
		
	}
}