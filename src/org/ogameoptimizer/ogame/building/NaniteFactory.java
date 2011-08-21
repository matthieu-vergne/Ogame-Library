package org.ogameoptimizer.ogame.building;

import org.ogameoptimizer.ogame.resource.ResourceSet;

public class NaniteFactory extends Building {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(1000000L, 500000L, 100000L);
	}

}
