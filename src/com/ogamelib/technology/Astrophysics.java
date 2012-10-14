package com.ogamelib.technology;

import com.ogamelib.resource.ResourceSet;

public class Astrophysics extends Technology {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(4000L, 8000L, 4000L);
	}

}
