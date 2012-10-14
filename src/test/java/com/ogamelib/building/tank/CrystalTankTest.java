package com.ogamelib.building.tank;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ogamelib.building.tank.CrystalTank;
import com.ogamelib.building.tank.Tank;
import com.ogamelib.resource.ResourceSet;

public class CrystalTankTest extends TankTest {

	@Override
	public Tank createStock() {
		return new CrystalTank();
	}

	@Test
	public void testLimit() {
		CrystalTank stock = new CrystalTank();

		{
			stock.setLevel(0);
			ResourceSet limit = stock.getLimit();
			assertEquals(0, (long) limit.metal.getAmount());
			assertEquals(10000, (long) limit.crystal.getAmount());
			assertEquals(0, (long) limit.deuterium.getAmount());
			assertEquals(0, (long) limit.antimatter.getAmount());
			assertEquals(0, (long) limit.energy.getAmount());
		}

		{
			stock.setLevel(1);
			ResourceSet limit = stock.getLimit();
			assertEquals(0, (long) limit.metal.getAmount());
			assertEquals(20000, (long) limit.crystal.getAmount());
			assertEquals(0, (long) limit.deuterium.getAmount());
			assertEquals(0, (long) limit.antimatter.getAmount());
			assertEquals(0, (long) limit.energy.getAmount());
		}

		{
			stock.setLevel(5);
			ResourceSet limit = stock.getLimit();
			assertEquals(0, (long) limit.metal.getAmount());
			assertEquals(255000, (long) limit.crystal.getAmount());
			assertEquals(0, (long) limit.deuterium.getAmount());
			assertEquals(0, (long) limit.antimatter.getAmount());
			assertEquals(0, (long) limit.energy.getAmount());
		}

		{
			stock.setLevel(10);
			ResourceSet limit = stock.getLimit();
			assertEquals(0, (long) limit.metal.getAmount());
			assertEquals(5355000, (long) limit.crystal.getAmount());
			assertEquals(0, (long) limit.deuterium.getAmount());
			assertEquals(0, (long) limit.antimatter.getAmount());
			assertEquals(0, (long) limit.energy.getAmount());
		}

		{
			stock.setLevel(15);
			ResourceSet limit = stock.getLimit();
			assertEquals(0, (long) limit.metal.getAmount());
			assertEquals(110925000, (long) limit.crystal.getAmount());
			assertEquals(0, (long) limit.deuterium.getAmount());
			assertEquals(0, (long) limit.antimatter.getAmount());
			assertEquals(0, (long) limit.energy.getAmount());
		}
	}

	@Test
	public void testCost() {
		CrystalTank stock = new CrystalTank();

		{
			stock.setLevel(0);
			ResourceSet cost = stock.getNextLevelCost();
			assertEquals(1000, (long) cost.metal.getAmount());
			assertEquals(500, (long) cost.crystal.getAmount());
			assertEquals(0, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}

		{
			stock.setLevel(1);
			ResourceSet cost = stock.getNextLevelCost();
			assertEquals(2000, (long) cost.metal.getAmount());
			assertEquals(1000, (long) cost.crystal.getAmount());
			assertEquals(0, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}

		// TODO complete with other levels
	}
}
