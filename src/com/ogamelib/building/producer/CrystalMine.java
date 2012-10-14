package com.ogamelib.building.producer;

import com.ogamelib.resource.ResourceSet;

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

	@Override
	public ResourceSet getNextLevelCost() {
		ResourceSet cost = new ResourceSet();
		cost.metal.setAmount((long) Math.floor(48 * Math.pow(1.6,
				getLevel())));
		cost.crystal.setAmount((long) Math.floor(24 * Math.pow(1.6,
				getLevel())));
		return cost;
	}
	
	@Override
	public ResourceSet getInitialCost() {
		return new CrystalMine().getNextLevelCost();
	}
}
