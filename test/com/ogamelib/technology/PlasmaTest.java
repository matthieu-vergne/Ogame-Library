package com.ogamelib.technology;

import org.junit.Test;

import com.ogamelib.resource.ResourceSet;
import com.ogamelib.technology.Plasma;
import com.ogamelib.technology.Technology;

import static org.junit.Assert.*;


public class PlasmaTest extends TechnologyTest {

	@Override
	public Technology createTechnology() {
		return new Plasma();
	}

	@Test
	public void testCostFormula() {
		Plasma technology = new Plasma();
		
		{
			technology.setLevel(0);
			ResourceSet cost = technology.getNextLevelCost();
			assertEquals(2000, (long) cost.metal.getAmount());
			assertEquals(4000, (long) cost.crystal.getAmount());
			assertEquals(1000, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
		
		// TODO complete with other levels
	}
}
