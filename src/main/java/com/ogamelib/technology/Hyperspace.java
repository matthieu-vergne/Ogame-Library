package com.ogamelib.technology;

import com.ogamelib.resource.ResourceSet;

public class Hyperspace extends Technology {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(0L, 4000L, 2000L);
	}

}
