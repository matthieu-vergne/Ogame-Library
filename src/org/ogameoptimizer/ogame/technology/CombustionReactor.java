package org.ogameoptimizer.ogame.technology;

import org.ogameoptimizer.ogame.resource.ResourceSet;

public class CombustionReactor extends Technology {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(400L, 0L, 600L);
	}

}
