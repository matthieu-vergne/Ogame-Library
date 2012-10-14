package com.ogamelib.technology;

import org.junit.Test;

import com.ogamelib.resource.ResourceSet;
import com.ogamelib.technology.ImpulsionReactor;
import com.ogamelib.technology.Technology;

import static org.junit.Assert.*;


public class ImpulsionReactorTest extends TechnologyTest {

	@Override
	public Technology createTechnology() {
		return new ImpulsionReactor();
	}

	@Test
	public void testCostFormula() {
		ImpulsionReactor technology = new ImpulsionReactor();
		
		{
			technology.setLevel(0);
			ResourceSet cost = technology.getNextLevelCost();
			assertEquals(2000, (long) cost.metal.getAmount());
			assertEquals(4000, (long) cost.crystal.getAmount());
			assertEquals(600, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
		
		// TODO complete with other levels
	}
}
