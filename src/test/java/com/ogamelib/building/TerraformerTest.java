package com.ogamelib.building;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ogamelib.building.Building;
import com.ogamelib.building.Terraformer;
import com.ogamelib.resource.ResourceSet;


public class TerraformerTest extends BuildingTest {

	@Override
	public Building createBuilding() {
		return new Terraformer();
	}

	@Test
	public void testCostFormula() {
		Terraformer building = new Terraformer();

		{
			building.setLevel(0);
			ResourceSet cost = building.getNextLevelCost();
			assertEquals(0, (long) cost.metal.getAmount());
			assertEquals(50000, (long) cost.crystal.getAmount());
			assertEquals(100000, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(1000, (long) cost.energy.getAmount());
		}
	}
}
