package org.ogameoptimizer.ogame.building.producer;

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
				* (1.44 - 0.004 * getPlanet().getTemperatureAverage()));
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
		cost.metal
				.setAmount((long) Math.floor(225 * Math.pow(1.5, getLevel())));
		cost.crystal
				.setAmount((long) Math.floor(75 * Math.pow(1.5, getLevel())));
		return cost;
	}

	@Override
	public ResourceSet getInitialCost() {
		return new DeuteriumMine().getNextLevelCost();
	}
}
