package org.ogameoptimizer.ogame.building;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.ogameoptimizer.ogame.resource.ResourceSet;


public class DockTest extends BuildingTest {

	@Override
	public Building createBuilding() {
		return new Dock();
	}

	@Test
	public void testCostFormula() {
		Dock building = new Dock();

		{
			building.setLevel(0);
			ResourceSet cost = building.getNextLevelCost();
			assertEquals(400, (long) cost.metal.getAmount());
			assertEquals(200, (long) cost.crystal.getAmount());
			assertEquals(100, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
	}
}
