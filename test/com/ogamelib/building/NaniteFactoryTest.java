package com.ogamelib.building;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ogamelib.building.Building;
import com.ogamelib.building.NaniteFactory;
import com.ogamelib.resource.ResourceSet;


public class NaniteFactoryTest extends BuildingTest {

	@Override
	public Building createBuilding() {
		return new NaniteFactory();
	}

	@Test
	public void testCostFormula() {
		NaniteFactory building = new NaniteFactory();

		{
			building.setLevel(0);
			ResourceSet cost = building.getNextLevelCost();
			assertEquals((long) 1e6, (long) cost.metal.getAmount());
			assertEquals(500000, (long) cost.crystal.getAmount());
			assertEquals(100000, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
	}
}
