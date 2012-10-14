package com.ogamelib.technology;

import org.junit.Test;

import com.ogamelib.resource.ResourceSet;
import com.ogamelib.technology.Graviton;
import com.ogamelib.technology.Technology;

import static org.junit.Assert.*;


public class GravitonTest extends TechnologyTest {

	@Override
	public Technology createTechnology() {
		return new Graviton();
	}

	@Test
	public void testCostFormula() {
		Graviton technology = new Graviton();
		
		{
			technology.setLevel(0);
			ResourceSet cost = technology.getNextLevelCost();
			assertEquals(0, (long) cost.metal.getAmount());
			assertEquals(0, (long) cost.crystal.getAmount());
			assertEquals(0, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(300000, (long) cost.energy.getAmount());
		}
		
		// TODO complete with other levels
	}
}
