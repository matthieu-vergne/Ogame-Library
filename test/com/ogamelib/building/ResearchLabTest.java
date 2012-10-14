package com.ogamelib.building;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ogamelib.building.Building;
import com.ogamelib.building.ResearchLab;
import com.ogamelib.resource.ResourceSet;


public class ResearchLabTest extends BuildingTest {

	@Override
	public Building createBuilding() {
		return new ResearchLab();
	}

	@Test
	public void testCostFormula() {
		ResearchLab building = new ResearchLab();

		{
			building.setLevel(0);
			ResourceSet cost = building.getNextLevelCost();
			assertEquals(400, (long) cost.metal.getAmount());
			assertEquals(800, (long) cost.crystal.getAmount());
			assertEquals(400, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
	}
}
