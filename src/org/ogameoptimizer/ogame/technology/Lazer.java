package org.ogameoptimizer.ogame.technology;

import org.ogameoptimizer.ogame.resource.ResourceSet;

public class Lazer extends Technology {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(200L, 100L, 0L);
	}

}
