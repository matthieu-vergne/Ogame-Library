package org.ogameoptimizer.ogame.technology;

import org.ogameoptimizer.ogame.resource.ResourceSet;

public class Ions extends Technology {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(1000L, 300L, 100L);
	}

}
