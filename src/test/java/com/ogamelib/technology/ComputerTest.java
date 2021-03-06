package com.ogamelib.technology;

import org.junit.Test;

import com.ogamelib.resource.ResourceSet;
import com.ogamelib.technology.Computer;
import com.ogamelib.technology.Technology;

import static org.junit.Assert.*;


public class ComputerTest extends TechnologyTest {

	@Override
	public Technology createTechnology() {
		return new Computer();
	}

	@Test
	public void testCostFormula() {
		Computer technology = new Computer();
		
		{
			technology.setLevel(0);
			ResourceSet cost = technology.getNextLevelCost();
			assertEquals(0, (long) cost.metal.getAmount());
			assertEquals(400, (long) cost.crystal.getAmount());
			assertEquals(600, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
		
		{
			technology.setLevel(3);
			ResourceSet cost = technology.getNextLevelCost();
			assertEquals(0, (long) cost.metal.getAmount());
			assertEquals(3200, (long) cost.crystal.getAmount());
			assertEquals(4800, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
		
		// TODO complete with other levels
	}
}
