package org.ogameoptimizer.ogame.technology;

import org.ogameoptimizer.ogame.resource.ResourceSet;

public class Spy extends Technology {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(200L, 1000L, 200L);
	}

}
