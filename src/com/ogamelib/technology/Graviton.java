package com.ogamelib.technology;

import com.ogamelib.resource.ResourceSet;

public class Graviton extends Technology {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(0L, 300000L);
	}

	@Override
	public ResourceSet getNextLevelCost() {
		ResourceSet cost = getInitialCost();
		cost.energy.setAmount((long) (cost.energy.getAmount() * Math.pow(3,
				getLevel())));
		return cost;
	}

}
