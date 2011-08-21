package org.ogameoptimizer.ogame.technology;

import org.ogameoptimizer.ogame.LeveledElement;
import org.ogameoptimizer.ogame.resource.Resource;
import org.ogameoptimizer.ogame.resource.ResourceSet;

public abstract class Technology extends LeveledElement {

	@Override
	public ResourceSet getNextLevelCost() {
		ResourceSet cost = getInitialCost();
		for (int i = 1; i < getLevel(); i++) {
			for (Resource resource : new Resource[] { cost.metal, cost.crystal,
					cost.deuterium, cost.antimatter, cost.energy }) {
				resource.setAmount(resource.getAmount() * 2 ^ i);
			}
		}
		return cost;
	}

	public abstract ResourceSet getInitialCost();
}
