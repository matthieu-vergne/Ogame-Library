package org.ogameoptimizer.ogame.building;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.ogameoptimizer.ogame.resource.ResourceSet;


public class SupplyDepositTest extends BuildingTest {

	@Override
	public Building createBuilding() {
		return new SupplyDeposit();
	}

	@Test
	public void testCostFormula() {
		SupplyDeposit building = new SupplyDeposit();

		{
			building.setLevel(0);
			ResourceSet cost = building.getNextLevelCost();
			assertEquals(20000, (long) cost.metal.getAmount());
			assertEquals(40000, (long) cost.crystal.getAmount());
			assertEquals(0, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
	}
}
