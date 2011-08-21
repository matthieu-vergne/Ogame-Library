package org.ogameoptimizer.ogame.technology;

import org.junit.Test;
import org.ogameoptimizer.ogame.resource.ResourceSet;

import static org.junit.Assert.*;


public class SpaceshipProtectionTest extends TechnologyTest {

	@Override
	public Technology createTechnology() {
		return new SpaceshipProtection();
	}

	@Test
	public void testCostFormula() {
		SpaceshipProtection technology = new SpaceshipProtection();
		
		{
			technology.setLevel(0);
			ResourceSet cost = technology.getNextLevelCost();
			assertEquals(1000, (long) cost.metal.getAmount());
			assertEquals(0, (long) cost.crystal.getAmount());
			assertEquals(0, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
		
		// TODO complete with other data
	}
}
