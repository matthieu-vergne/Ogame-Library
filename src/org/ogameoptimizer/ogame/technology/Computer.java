package org.ogameoptimizer.ogame.technology;

import org.ogameoptimizer.ogame.resource.ResourceSet;

public class Computer extends Technology {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(0L, 400L, 600L);
	}

}
