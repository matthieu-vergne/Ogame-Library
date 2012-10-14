package com.ogamelib.building;

import com.ogamelib.resource.ResourceSet;

public class Dock extends Building {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(400L, 200L, 100L);
	}

}
