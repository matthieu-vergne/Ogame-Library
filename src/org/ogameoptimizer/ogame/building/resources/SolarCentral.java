package org.ogameoptimizer.ogame.building.resources;

import org.ogameoptimizer.ogame.resource.ResourceSet;

public class SolarCentral extends Producer {

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
		return 0L;
	}

	@Override
	public Long getProductionBaseForAntimatter() {
		return 0L;
	}

	@Override
	public Long getProductionBaseForEnergy() {
		return (long) (20 * getLevel() * Math.pow(1.1, getLevel()));
	}

	/**
	 * The solar central production is not limited by other parameters, so this
	 * method is equivalent to {@link #getMaximumProductionRate()}.
	 */
	@Override
	public Double getActualProductionRate() {
		return getMaximumProductionRate();
	}

	@Override
	public ResourceSet getNextLevelCost() {
		ResourceSet cost = new ResourceSet();
		cost.metal.setAmount((long) Math.floor(75 * Math.pow(1.5,
				getLevel())));
		cost.crystal.setAmount((long) Math.floor(30 * Math.pow(1.5,
				getLevel())));
		return cost;
	}
}
