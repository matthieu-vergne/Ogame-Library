package com.ogamelib.technology;

import com.ogamelib.resource.ResourceSet;

public class Weapon extends Technology {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(800L, 200L, 0L);
	}

}
