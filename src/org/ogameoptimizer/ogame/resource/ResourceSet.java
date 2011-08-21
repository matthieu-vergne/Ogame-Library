package org.ogameoptimizer.ogame.resource;

public class ResourceSet {
	public final Metal metal = new Metal();
	public final Crystal crystal = new Crystal();
	public final Deuterium deuterium = new Deuterium();
	public final Antimatter antimatter = new Antimatter();
	public final Energy energy = new Energy();
	
	public ResourceSet() {
	}
	
	public ResourceSet(Long metal, Long crystal, Long deuterium) {
		this.metal.setAmount(metal);
		this.crystal.setAmount(crystal);
		this.deuterium.setAmount(deuterium);
	}
	
	public ResourceSet(Long antimatter, Long energy) {
		this.antimatter.setAmount(antimatter);
		this.energy.setAmount(energy);
	}
	
}
