package com.ogamelib.technology;

import org.junit.Test;

import com.ogamelib.resource.ResourceSet;
import com.ogamelib.technology.HyperspacePropulsion;
import com.ogamelib.technology.Technology;

import static org.junit.Assert.*;


public class HyperspacePropulsionTest extends TechnologyTest {

	@Override
	public Technology createTechnology() {
		return new HyperspacePropulsion();
	}

	@Test
	public void testCostFormula() {
		HyperspacePropulsion technology = new HyperspacePropulsion();
		
		{
			technology.setLevel(0);
			ResourceSet cost = technology.getNextLevelCost();
			assertEquals(10000, (long) cost.metal.getAmount());
			assertEquals(20000, (long) cost.crystal.getAmount());
			assertEquals(6000, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
		
		// TODO complete with other levels
	}
}
