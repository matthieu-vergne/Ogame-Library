package org.ogameoptimizer.ogame.technology;

import org.junit.Test;
import org.ogameoptimizer.ogame.resource.ResourceSet;

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
		
		// TODO complete with other data
	}
}
