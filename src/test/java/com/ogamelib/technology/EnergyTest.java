package com.ogamelib.technology;

import org.junit.Test;

import com.ogamelib.resource.ResourceSet;
import com.ogamelib.technology.Energy;
import com.ogamelib.technology.Technology;

import static org.junit.Assert.*;


public class EnergyTest extends TechnologyTest {

	@Override
	public Technology createTechnology() {
		return new Energy();
	}

	@Test
	public void testCostFormula() {
		Energy technology = new Energy();
		
		{
			technology.setLevel(0);
			ResourceSet cost = technology.getNextLevelCost();
			assertEquals(0, (long) cost.metal.getAmount());
			assertEquals(800, (long) cost.crystal.getAmount());
			assertEquals(400, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
		
		{
			technology.setLevel(3);
			ResourceSet cost = technology.getNextLevelCost();
			assertEquals(0, (long) cost.metal.getAmount());
			assertEquals(6400, (long) cost.crystal.getAmount());
			assertEquals(3200, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
		
		// TODO complete with other levels
	}
}
