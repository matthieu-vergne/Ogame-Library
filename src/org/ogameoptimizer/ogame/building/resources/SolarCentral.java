package org.ogameoptimizer.ogame.building.resources;

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
}
