package org.ogameoptimizer.ogame.technology;

import org.ogameoptimizer.ogame.resource.ResourceSet;

public class HyperspacePropulsion extends Technology {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(10000L, 20000L, 6000L);
	}

}
