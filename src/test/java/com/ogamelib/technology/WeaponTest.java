package com.ogamelib.technology;

import org.junit.Test;

import com.ogamelib.resource.ResourceSet;
import com.ogamelib.technology.Technology;
import com.ogamelib.technology.Weapon;

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
		
		{
			technology.setLevel(3);
			ResourceSet cost = technology.getNextLevelCost();
			assertEquals(6400, (long) cost.metal.getAmount());
			assertEquals(1600, (long) cost.crystal.getAmount());
			assertEquals(0, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
		
		// TODO complete with other levels
	}
}
