package com.ogamelib.technology;

import org.junit.Test;

import com.ogamelib.resource.ResourceSet;
import com.ogamelib.technology.Hyperspace;
import com.ogamelib.technology.Technology;

import static org.junit.Assert.*;


public class HyperspaceTest extends TechnologyTest {

	@Override
	public Technology createTechnology() {
		return new Hyperspace();
	}

	@Test
	public void testCostFormula() {
		Hyperspace technology = new Hyperspace();
		
		{
			technology.setLevel(0);
			ResourceSet cost = technology.getNextLevelCost();
			assertEquals(0, (long) cost.metal.getAmount());
			assertEquals(4000, (long) cost.crystal.getAmount());
			assertEquals(2000, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
		
		// TODO complete with other levels
	}
}
