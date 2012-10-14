package com.ogamelib.building;

import com.ogamelib.resource.ResourceSet;

public class SupplyDeposit extends Building {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(20000L, 40000L, 0L);
	}

}
