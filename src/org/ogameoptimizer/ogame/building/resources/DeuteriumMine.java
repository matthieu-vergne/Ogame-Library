package org.ogameoptimizer.ogame.building.resources;


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
}
