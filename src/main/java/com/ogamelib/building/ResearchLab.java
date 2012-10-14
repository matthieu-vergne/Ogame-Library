package com.ogamelib.building;

import com.ogamelib.resource.ResourceSet;

public class ResearchLab extends Building {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(400L, 800L, 400L);
	}

}
