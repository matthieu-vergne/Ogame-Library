package org.ogameoptimizer.ogame.building.stock;

import org.ogameoptimizer.ogame.resource.ResourceSet;

public class MetalStock extends Stock {

	@Override
	public ResourceSet getInitialLimit() {
		return new ResourceSet(10000L, 0L, 0L);
	}

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(1000L, 0L, 0L);
	}

}
