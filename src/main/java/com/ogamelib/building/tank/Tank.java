package com.ogamelib.building.tank;

import com.ogamelib.building.Building;
import com.ogamelib.resource.Resource;
import com.ogamelib.resource.ResourceSet;

public abstract class Tank extends Building {

	public abstract ResourceSet getInitialLimit();

	public ResourceSet getLimit() {
		ResourceSet limit = getInitialLimit();
		for (Resource resource : new Resource[] { limit.metal, limit.crystal,
				limit.deuterium, limit.antimatter, limit.energy }) {
			if (resource.getAmount() > 0 && getLevel() > 0) {
				resource.setAmount((long) (5000 * Math.floor(2.5 * Math
						.exp(20.0 / 33.0 * getLevel()))));
			}
		}
		return limit;
	}

	public abstract ResourceSet getInitialCost();

}
