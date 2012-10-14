package com.ogamelib.technology;

import com.ogamelib.resource.ResourceSet;

public class HyperspacePropulsion extends Technology {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(10000L, 20000L, 6000L);
	}

}
