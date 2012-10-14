package com.ogamelib.building.tank;

import com.ogamelib.resource.ResourceSet;

public class MetalTank extends Tank {

	@Override
	public ResourceSet getInitialLimit() {
		return new ResourceSet(10000L, 0L, 0L);
	}

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(1000L, 0L, 0L);
	}

}
