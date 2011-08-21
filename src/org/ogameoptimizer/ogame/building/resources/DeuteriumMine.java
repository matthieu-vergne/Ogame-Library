package org.ogameoptimizer.ogame.building.resources;

import org.ogameoptimizer.ogame.resource.ResourceSet;


public class DeuteriumMine extends Producer {

	@Override
	public Long getProductionBaseForMetal() {
		return 0L;
	}

	@Override
	public Long getProductionBaseForCrystal() {
		return 0L;
	}

	@Override
	public Long getProductionBaseForDeuterium() {
		return (long) Math.floor((double) 10 * getLevel()
				* Math.pow(1.1, getLevel())
				* (-0.002 * getPlanet().getTemperatureMax() + 1.28));
	}

	@Override
	public Long getProductionBaseForAntimatter() {
		return 0L;
	}

	@Override
	public Long getProductionBaseForEnergy() {
		return (long) Math.floor(-20 * getLevel() * Math.pow(1.1, getLevel()));
	}

	@Override
	public ResourceSet getNextLevelCost() {
		ResourceSet cost = new ResourceSet();
		cost.metal.setAmount((long) Math.floor(225 * Math.pow(1.5,
				getLevel())));
		cost.crystal.setAmount((long) Math.floor(75 * Math.pow(1.5,
				getLevel())));
		return cost;
	}
}
