package org.ogameoptimizer.ogame.building;

import org.ogameoptimizer.ogame.resource.ResourceSet;

public class RobotFactory extends Building {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(400L, 120L, 200L);
	}

}
