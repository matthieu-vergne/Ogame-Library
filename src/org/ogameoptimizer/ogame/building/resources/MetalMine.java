package org.ogameoptimizer.ogame.building.resources;


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
}
