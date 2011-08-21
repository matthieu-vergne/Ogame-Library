package org.ogameoptimizer.ogame.building.resources;



public class CrystalMine extends Producer {

	@Override
	public Long getProductionBaseForMetal() {
		return 0L;
	}

	@Override
	public Long getProductionBaseForCrystal() {
		return (long) Math.floor((double) 20 * getLevel()
				* Math.pow(1.1, getLevel()));
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
