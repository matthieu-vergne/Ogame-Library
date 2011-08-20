package org.ogameoptimizer.ogame.building.resources;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
}
