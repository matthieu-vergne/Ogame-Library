package com.ogamelib.technology;

import org.junit.Test;

import com.ogamelib.resource.ResourceSet;
import com.ogamelib.technology.Lazer;
import com.ogamelib.technology.Technology;

import static org.junit.Assert.*;


public class LazerTest extends TechnologyTest {

	@Override
	public Technology createTechnology() {
		return new Lazer();
	}

	@Test
	public void testCostFormula() {
		Lazer technology = new Lazer();
		
		{
			technology.setLevel(0);
			ResourceSet cost = technology.getNextLevelCost();
			assertEquals(200, (long) cost.metal.getAmount());
			assertEquals(100, (long) cost.crystal.getAmount());
			assertEquals(0, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
		
		{
			technology.setLevel(6);
			ResourceSet cost = technology.getNextLevelCost();
			assertEquals(12800, (long) cost.metal.getAmount());
			assertEquals(6400, (long) cost.crystal.getAmount());
			assertEquals(0, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
		
		// TODO complete with other levels
	}
}
