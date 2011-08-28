package org.ogameoptimizer.ogame.technology;

import org.ogameoptimizer.ogame.resource.ResourceSet;

public class Energy extends Technology {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(0L, 800L, 400L);
	}

}
