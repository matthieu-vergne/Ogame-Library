package com.ogamelib.building.producer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ogamelib.building.producer.MetalMine;
import com.ogamelib.building.producer.Producer;
import com.ogamelib.resource.ResourceSet;

public class MetalMineTest extends ProducerTest {

	@Override
	public Producer createProducer() {
		return new MetalMine();
	}

	@Test
	public void testProductionFormula() {
		MetalMine mine = new MetalMine();

		mine.setLevel(2);
		assertEquals(72, (long) mine.getProductionBaseForMetal());

		mine.setLevel(5);
		assertEquals(241, (long) mine.getProductionBaseForMetal());

		mine.setLevel(10);
		assertEquals(778, (long) mine.getProductionBaseForMetal());

		mine.setLevel(15);
		assertEquals(1879, (long) mine.getProductionBaseForMetal());
	}

	@Test
	public void testEnergyFormula() {
		MetalMine mine = new MetalMine();

		mine.setLevel(2);
		assertEquals(-25, (long) mine.getProductionBaseForEnergy());

		mine.setLevel(5);
		assertEquals(-81, (long) mine.getProductionBaseForEnergy());

		mine.setLevel(10);
		assertEquals(-260, (long) mine.getProductionBaseForEnergy());

		mine.setLevel(15);
		assertEquals(-627, (long) mine.getProductionBaseForEnergy());
	}

	@Test
	public void testCostFormula() {
		MetalMine mine = new MetalMine();

		{
			mine.setLevel(5);
			ResourceSet cost = mine.getNextLevelCost();
			assertEquals(455, (long) cost.metal.getAmount());
			assertEquals(113, (long) cost.crystal.getAmount());
			assertEquals(0, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
		
		{
			mine.setLevel(6);
			ResourceSet cost = mine.getNextLevelCost();
			assertEquals(683, (long) cost.metal.getAmount());
			assertEquals(170, (long) cost.crystal.getAmount());
			assertEquals(0, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
		
		{
			mine.setLevel(13);
			ResourceSet cost = mine.getNextLevelCost();
			assertEquals(11677, (long) cost.metal.getAmount());
			assertEquals(2919, (long) cost.crystal.getAmount());
			assertEquals(0, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
	}
}
