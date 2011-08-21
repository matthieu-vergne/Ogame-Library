package org.ogameoptimizer.ogame.building.producer;

import org.ogameoptimizer.ogame.resource.ResourceSet;

public class FusionCentral extends Producer {

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
		return (long) Math.floor(-10 * getLevel() * Math.pow(1.1, getLevel()));
	}

	@Override
	public Long getProductionBaseForAntimatter() {
		return 0L;
	}

	@Override
	public Long getProductionBaseForEnergy() {
		return (long) (30 * getLevel() * Math.pow(1.05 + getPlanet()
				.getTechnologies().energy.getLevel() * 0.01, getLevel()));
	}

	@Override
	public ResourceSet getNextLevelCost() {
		ResourceSet cost = new ResourceSet();
		cost.metal
				.setAmount((long) Math.floor(900 * Math.pow(1.8, getLevel())));
		cost.crystal.setAmount((long) Math.floor(360 * Math
				.pow(1.8, getLevel())));
		cost.deuterium.setAmount((long) Math.floor(180 * Math.pow(1.8,
				getLevel())));
		return cost;
	}
}
