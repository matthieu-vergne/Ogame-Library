package com.ogamelib.technology;

import com.ogamelib.resource.ResourceSet;

public class Ions extends Technology {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(1000L, 300L, 100L);
	}

}
