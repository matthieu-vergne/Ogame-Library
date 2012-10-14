package com.ogamelib.technology;

import com.ogamelib.resource.ResourceSet;

public class ImpulsionReactor extends Technology {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(2000L, 4000L, 600L);
	}

}
