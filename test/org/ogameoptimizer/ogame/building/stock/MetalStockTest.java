package org.ogameoptimizer.ogame.building.stock;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.ogameoptimizer.ogame.resource.ResourceSet;

public class MetalStockTest extends StockTest {

	@Override
	public Stock createStock() {
		return new MetalStock();
	}

	@Test
	public void testLimit() {
		MetalStock stock = new MetalStock();

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
		MetalStock stock = new MetalStock();

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
