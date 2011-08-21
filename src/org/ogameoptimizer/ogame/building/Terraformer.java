package org.ogameoptimizer.ogame.building;

import org.ogameoptimizer.ogame.resource.ResourceSet;

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
