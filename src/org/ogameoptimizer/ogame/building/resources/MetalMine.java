package org.ogameoptimizer.ogame.building.resources;

import org.ogameoptimizer.ogame.resource.ResourceSet;


public class MetalMine extends Producer {

	@Override
	public Long getProductionBaseForMetal() {
		return (long) Math.floor((double) 30 * getLevel()
				* Math.pow(1.1, getLevel()));
	}

	@Override
	public Long getProductionBaseForCrystal() {
		return 0L;
	}

	@Override
	public Long getProductionBaseForDeuterium() {
		return 0L;
	}

	@Override
	public Long getProductionBaseForAntimatter() {
		return 0L;
	}

	@Override
	public Long getProductionBaseForEnergy() {
		return (long) Math.floor(-10 * getLevel() * Math.pow(1.1, getLevel()));
	}

	@Override
	public ResourceSet getNextLevelCost() {
		ResourceSet cost = new ResourceSet();
		cost.metal.setAmount((long) Math.floor(60 * Math.pow(1.5,
				getLevel())));
		cost.crystal.setAmount((long) Math.floor(15 * Math.pow(1.5,
				getLevel())));
		return cost;
	}
}
