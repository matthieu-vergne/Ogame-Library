package org.ogameoptimizer.ogame.technology;

import org.junit.Test;
import org.ogameoptimizer.ogame.resource.ResourceSet;

import static org.junit.Assert.*;


public class WeaponTest extends TechnologyTest {

	@Override
	public Technology createTechnology() {
		return new Weapon();
	}

	@Test
	public void testCostFormula() {
		Weapon technology = new Weapon();
		
		{
			technology.setLevel(0);
			ResourceSet cost = technology.getNextLevelCost();
			assertEquals(800, (long) cost.metal.getAmount());
			assertEquals(200, (long) cost.crystal.getAmount());
			assertEquals(0, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
		
		// TODO complete with other data
	}
}
