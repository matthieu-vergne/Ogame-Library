package org.ogameoptimizer.ogame.building.resources;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
}
