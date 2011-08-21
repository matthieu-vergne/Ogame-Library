package org.ogameoptimizer.ogame.building.stock;

import org.ogameoptimizer.ogame.resource.ResourceSet;

public class CrystalStock extends Stock {

	@Override
	public ResourceSet getInitialLimit() {
		return new ResourceSet(0L, 10000L, 0L);
	}

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(1000L, 500L, 0L);
	}

}
