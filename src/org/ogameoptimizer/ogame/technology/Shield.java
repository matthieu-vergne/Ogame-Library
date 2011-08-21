package org.ogameoptimizer.ogame.technology;

import org.ogameoptimizer.ogame.resource.ResourceSet;

public class Shield extends Technology {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(200L, 600L, 0L);
	}

}
