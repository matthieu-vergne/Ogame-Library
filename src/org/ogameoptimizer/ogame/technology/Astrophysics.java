package org.ogameoptimizer.ogame.technology;

import org.ogameoptimizer.ogame.resource.ResourceSet;

public class Astrophysics extends Technology {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(4000L, 8000L, 4000L);
	}

}
