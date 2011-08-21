package org.ogameoptimizer.ogame.technology;

import org.junit.Test;
import org.ogameoptimizer.ogame.resource.ResourceSet;

import static org.junit.Assert.*;


public class AstrophysicsTest extends TechnologyTest {

	@Override
	public Technology createTechnology() {
		return new Astrophysics();
	}

	@Test
	public void testCostFormula() {
		Astrophysics technology = new Astrophysics();
		
		{
			technology.setLevel(0);
			ResourceSet cost = technology.getNextLevelCost();
			assertEquals(4000, (long) cost.metal.getAmount());
			assertEquals(8000, (long) cost.crystal.getAmount());
			assertEquals(4000, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
		
		// TODO complete with other data
	}
}
