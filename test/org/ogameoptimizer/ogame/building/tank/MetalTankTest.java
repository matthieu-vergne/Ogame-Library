package org.ogameoptimizer.ogame.building.tank;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.ogameoptimizer.ogame.building.tank.MetalTank;
import org.ogameoptimizer.ogame.building.tank.Tank;
import org.ogameoptimizer.ogame.resource.ResourceSet;

public class MetalTankTest extends TankTest {

	@Override
	public Tank createStock() {
		return new MetalTank();
	}

	@Test
	public void testLimit() {
		MetalTank stock = new MetalTank();

		{
			stock.setLevel(0);
			ResourceSet limit = stock.getLimit();
			assertEquals(10000, (long) limit.metal.getAmount());
			assertEquals(0, (long) limit.crystal.getAmount());
			assertEquals(0, (long) limit.deuterium.getAmount());
			assertEquals(0, (long) limit.antimatter.getAmount());
			assertEquals(0, (long) limit.energy.getAmount());
		}

		{
			stock.setLevel(1);
			ResourceSet limit = stock.getLimit();
			assertEquals(20000, (long) limit.metal.getAmount());
			assertEquals(0, (long) limit.crystal.getAmount());
			assertEquals(0, (long) limit.deuterium.getAmount());
			assertEquals(0, (long) limit.antimatter.getAmount());
			assertEquals(0, (long) limit.energy.getAmount());
		}

		{
			stock.setLevel(5);
			ResourceSet limit = stock.getLimit();
			assertEquals(255000, (long) limit.metal.getAmount());
			assertEquals(0, (long) limit.crystal.getAmount());
			assertEquals(0, (long) limit.deuterium.getAmount());
			assertEquals(0, (long) limit.antimatter.getAmount());
			assertEquals(0, (long) limit.energy.getAmount());
		}

		{
			stock.setLevel(10);
			ResourceSet limit = stock.getLimit();
			assertEquals(5355000, (long) limit.metal.getAmount());
			assertEquals(0, (long) limit.crystal.getAmount());
			assertEquals(0, (long) limit.deuterium.getAmount());
			assertEquals(0, (long) limit.antimatter.getAmount());
			assertEquals(0, (long) limit.energy.getAmount());
		}

		{
			stock.setLevel(15);
			ResourceSet limit = stock.getLimit();
			assertEquals(110925000, (long) limit.metal.getAmount());
			assertEquals(0, (long) limit.crystal.getAmount());
			assertEquals(0, (long) limit.deuterium.getAmount());
			assertEquals(0, (long) limit.antimatter.getAmount());
			assertEquals(0, (long) limit.energy.getAmount());
		}
	}

	@Test
	public void testCost() {
		MetalTank stock = new MetalTank();

		{
			stock.setLevel(0);
			ResourceSet cost = stock.getNextLevelCost();
			assertEquals(1000, (long) cost.metal.getAmount());
			assertEquals(0, (long) cost.crystal.getAmount());
			assertEquals(0, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}

		// TODO complete with other levels
	}
}
