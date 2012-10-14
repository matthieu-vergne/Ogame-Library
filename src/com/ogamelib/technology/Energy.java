package com.ogamelib.technology;

import com.ogamelib.resource.ResourceSet;

public class Energy extends Technology {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(0L, 800L, 400L);
	}

}
