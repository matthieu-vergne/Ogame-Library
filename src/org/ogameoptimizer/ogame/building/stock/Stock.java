package org.ogameoptimizer.ogame.building.stock;

import org.ogameoptimizer.ogame.building.Building;
import org.ogameoptimizer.ogame.resource.Resource;
import org.ogameoptimizer.ogame.resource.ResourceSet;

public abstract class Stock extends Building {

	public abstract ResourceSet getInitialLimit();

	public ResourceSet getLimit() {
		ResourceSet limit = getInitialLimit();
		for (Resource resource : new Resource[] {}) {
			resource.setAmount((long) (resource.getAmount() + 5000 * Math
					.floor(Math.pow(1.6, getLevel()))));
		}
		return limit;
	}
	
	public abstract ResourceSet getInitialCost();

}
