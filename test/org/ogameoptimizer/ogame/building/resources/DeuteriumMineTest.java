package org.ogameoptimizer.ogame.building.resources;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.ogameoptimizer.ogame.Planet;
import org.ogameoptimizer.ogame.resource.ResourceSet;

public class DeuteriumMineTest extends ProducerTest {

	@Override
	public Producer createProducer() {
		return new DeuteriumMine();
	}

	@Test
	public void testProductionFormula() {
		DeuteriumMine mine = new DeuteriumMine();
		mine.setPlanet(new Planet());

		mine.setLevel(1);
		assertEquals(15, (long) mine.getProductionBaseForDeuterium());

		mine.setLevel(5);
		assertEquals(113, (long) mine.getProductionBaseForDeuterium());

		mine.setLevel(10);
		assertEquals(365, (long) mine.getProductionBaseForDeuterium());

		mine.setLevel(15);
		assertEquals(882, (long) mine.getProductionBaseForDeuterium());
	}

	@Test
	public void testEnergyFormula() {
		DeuteriumMine mine = new DeuteriumMine();

		mine.setLevel(1);
		assertEquals(-22, (long) mine.getProductionBaseForEnergy());

		mine.setLevel(5);
		assertEquals(-162, (long) mine.getProductionBaseForEnergy());

		mine.setLevel(10);
		assertEquals(-519, (long) mine.getProductionBaseForEnergy());

		mine.setLevel(15);
		assertEquals(-1254, (long) mine.getProductionBaseForEnergy());
	}

	@Test
	public void testCostFormula() {
		DeuteriumMine mine = new DeuteriumMine();

		{
			mine.setLevel(3);
			ResourceSet cost = mine.getNextLevelCost();
			assertEquals(759, (long) cost.metal.getAmount());
			assertEquals(253, (long) cost.crystal.getAmount());
			assertEquals(0, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
	}
}
