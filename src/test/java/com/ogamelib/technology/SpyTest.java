package com.ogamelib.technology;

import org.junit.Test;

import com.ogamelib.resource.ResourceSet;
import com.ogamelib.technology.Spy;
import com.ogamelib.technology.Technology;

import static org.junit.Assert.*;


public class SpyTest extends TechnologyTest {

	@Override
	public Technology createTechnology() {
		return new Spy();
	}

	@Test
	public void testCostFormula() {
		Spy technology = new Spy();
		
		{
			technology.setLevel(0);
			ResourceSet cost = technology.getNextLevelCost();
			assertEquals(200, (long) cost.metal.getAmount());
			assertEquals(1000, (long) cost.crystal.getAmount());
			assertEquals(200, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
		
		{
			technology.setLevel(2);
			ResourceSet cost = technology.getNextLevelCost();
			assertEquals(800, (long) cost.metal.getAmount());
			assertEquals(4000, (long) cost.crystal.getAmount());
			assertEquals(800, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
		
		// TODO complete with other levels
	}
}
