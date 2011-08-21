package org.ogameoptimizer.ogame.building.producer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.ogameoptimizer.ogame.building.producer.CrystalMine;
import org.ogameoptimizer.ogame.building.producer.Producer;
import org.ogameoptimizer.ogame.resource.ResourceSet;

public class CrystalMineTest extends ProducerTest {

	@Override
	public Producer createProducer() {
		return new CrystalMine();
	}

	@Test
	public void testProductionFormula() {
		CrystalMine mine = new CrystalMine();

		mine.setLevel(1);
		assertEquals(22, (long) mine.getProductionBaseForCrystal());

		mine.setLevel(5);
		assertEquals(161, (long) mine.getProductionBaseForCrystal());

		mine.setLevel(10);
		assertEquals(518, (long) mine.getProductionBaseForCrystal());

		mine.setLevel(15);
		assertEquals(1253, (long) mine.getProductionBaseForCrystal());
	}

	@Test
	public void testEnergyFormula() {
		CrystalMine mine = new CrystalMine();

		mine.setLevel(1);
		assertEquals(-11, (long) mine.getProductionBaseForEnergy());

		mine.setLevel(5);
		assertEquals(-81, (long) mine.getProductionBaseForEnergy());

		mine.setLevel(10);
		assertEquals(-260, (long) mine.getProductionBaseForEnergy());

		mine.setLevel(15);
		assertEquals(-627, (long) mine.getProductionBaseForEnergy());
	}

	@Test
	public void testCostFormula() {
		CrystalMine mine = new CrystalMine();

		{
			mine.setLevel(4);
			ResourceSet cost = mine.getNextLevelCost();
			assertEquals(314, (long) cost.metal.getAmount());
			assertEquals(157, (long) cost.crystal.getAmount());
			assertEquals(0, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
	}
}
