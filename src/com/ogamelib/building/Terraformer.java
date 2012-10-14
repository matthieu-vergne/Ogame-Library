package com.ogamelib.building;

import com.ogamelib.resource.ResourceSet;

public class Terraformer extends Building {

	@Override
	public ResourceSet getInitialCost() {
		ResourceSet cost = new ResourceSet();
		cost.crystal.setAmount(50000L);
		cost.deuterium.setAmount(100000L);
		cost.energy.setAmount(1000L);
		return cost;
	}

}
