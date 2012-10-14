package com.ogamelib.building;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ogamelib.building.Building;
import com.ogamelib.building.RobotFactory;
import com.ogamelib.resource.ResourceSet;


public class RobotFactoryTest extends BuildingTest {

	@Override
	public Building createBuilding() {
		return new RobotFactory();
	}

	@Test
	public void testCostFormula() {
		RobotFactory building = new RobotFactory();

		{
			building.setLevel(2);
			ResourceSet cost = building.getNextLevelCost();
			assertEquals(1600, (long) cost.metal.getAmount());
			assertEquals(480, (long) cost.crystal.getAmount());
			assertEquals(800, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
	}
}
