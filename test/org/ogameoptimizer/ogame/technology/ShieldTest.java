package org.ogameoptimizer.ogame.technology;

import org.junit.Test;
import org.ogameoptimizer.ogame.resource.ResourceSet;

import static org.junit.Assert.*;


public class ShieldTest extends TechnologyTest {

	@Override
	public Technology createTechnology() {
		return new Shield();
	}

	@Test
	public void testCostFormula() {
		Shield technology = new Shield();
		
		{
			technology.setLevel(0);
			ResourceSet cost = technology.getNextLevelCost();
			assertEquals(200, (long) cost.metal.getAmount());
			assertEquals(600, (long) cost.crystal.getAmount());
			assertEquals(0, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
		
		// TODO complete with other levels
	}
}
