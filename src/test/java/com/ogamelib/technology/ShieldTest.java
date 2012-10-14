package com.ogamelib.technology;

import org.junit.Test;

import com.ogamelib.resource.ResourceSet;
import com.ogamelib.technology.Shield;
import com.ogamelib.technology.Technology;

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
