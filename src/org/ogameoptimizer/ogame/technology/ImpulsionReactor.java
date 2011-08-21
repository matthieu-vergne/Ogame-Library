package org.ogameoptimizer.ogame.technology;

import org.ogameoptimizer.ogame.resource.ResourceSet;

public class ImpulsionReactor extends Technology {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(2000L, 4000L, 600L);
	}

}
