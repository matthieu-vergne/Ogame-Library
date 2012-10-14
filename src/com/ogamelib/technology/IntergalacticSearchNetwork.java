package com.ogamelib.technology;

import com.ogamelib.resource.ResourceSet;

public class IntergalacticSearchNetwork extends Technology {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(240000L, 400000L, 160000L);
	}

}
