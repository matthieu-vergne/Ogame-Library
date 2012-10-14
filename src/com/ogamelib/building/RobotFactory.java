package com.ogamelib.building;

import com.ogamelib.resource.ResourceSet;

public class RobotFactory extends Building {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(400L, 120L, 200L);
	}

}
