package com.ogamelib.technology;

import com.ogamelib.resource.ResourceSet;

public class Computer extends Technology {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(0L, 400L, 600L);
	}

}
