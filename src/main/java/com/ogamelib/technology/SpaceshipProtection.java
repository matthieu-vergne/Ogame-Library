package com.ogamelib.technology;

import com.ogamelib.resource.ResourceSet;

public class SpaceshipProtection extends Technology {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(1000L, 0L, 0L);
	}

}
