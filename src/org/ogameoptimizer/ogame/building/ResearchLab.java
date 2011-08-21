package org.ogameoptimizer.ogame.building;

import org.ogameoptimizer.ogame.resource.ResourceSet;

public class ResearchLab extends Building {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(400L, 800L, 400L);
	}

}
