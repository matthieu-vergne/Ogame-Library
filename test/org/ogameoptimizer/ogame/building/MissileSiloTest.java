package org.ogameoptimizer.ogame.building;

import static org.junit.Assert.*;

import org.junit.Test;
import org.ogameoptimizer.ogame.resource.ResourceSet;


public class MissileSiloTest extends BuildingTest {

	@Override
	public Building createBuilding() {
		return new MissileSilo();
	}

	@Test
	public void testCostFormula() {
		MissileSilo building = new MissileSilo();

		{
			building.setLevel(0);
			ResourceSet cost = building.getNextLevelCost();
			assertEquals(20000, (long) cost.metal.getAmount());
			assertEquals(20000, (long) cost.crystal.getAmount());
			assertEquals(1000, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
	}
	
	@Test
	public void testCapacity() {
		MissileSilo silo = new MissileSilo();
		
		silo.setLevel(0);
		assertEquals(0, (int) silo.getCapacity());
		assertEquals(0, (int) silo.getFreeSpace());
		
		silo.setLevel(1);
		assertEquals(10, (int) silo.getCapacity());
		assertEquals(10, (int) silo.getFreeSpace());
		
		silo.setLevel(5);
		assertEquals(50, (int) silo.getCapacity());
		assertEquals(50, (int) silo.getFreeSpace());
		
		silo.setLevel(10);
		assertEquals(100, (int) silo.getCapacity());
		assertEquals(100, (int) silo.getFreeSpace());
		
		silo.setInterceptionMissileCount(5);
		assertEquals(100, (int) silo.getCapacity());
		assertEquals(95, (int) silo.getFreeSpace());
		
		silo.setInterplanetaryMissileCount(20);
		assertEquals(100, (int) silo.getCapacity());
		assertEquals(55, (int) silo.getFreeSpace());
	}
}
