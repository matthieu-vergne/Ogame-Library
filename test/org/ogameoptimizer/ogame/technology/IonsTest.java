package org.ogameoptimizer.ogame.technology;

import org.junit.Test;
import org.ogameoptimizer.ogame.resource.ResourceSet;

import static org.junit.Assert.*;


public class IonsTest extends TechnologyTest {

	@Override
	public Technology createTechnology() {
		return new Ions();
	}

	@Test
	public void testCostFormula() {
		Ions technology = new Ions();
		
		{
			technology.setLevel(0);
			ResourceSet cost = technology.getNextLevelCost();
			assertEquals(1000, (long) cost.metal.getAmount());
			assertEquals(300, (long) cost.crystal.getAmount());
			assertEquals(100, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
		
		// TODO complete with other data
	}
}
