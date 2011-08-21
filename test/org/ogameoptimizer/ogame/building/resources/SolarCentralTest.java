package org.ogameoptimizer.ogame.building.resources;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.ogameoptimizer.ogame.resource.ResourceSet;

public class SolarCentralTest extends ProducerTest {

	@Override
	public Producer createProducer() {
		return new SolarCentral();
	}

	@Test
	public void testProductionFormula() {
		SolarCentral central = new SolarCentral();

		central.setLevel(2);
		assertEquals(48, (long) central.getProductionBaseForEnergy());

		central.setLevel(5);
		assertEquals(161, (long) central.getProductionBaseForEnergy());

		central.setLevel(10);
		assertEquals(518, (long) central.getProductionBaseForEnergy());

		central.setLevel(15);
		assertEquals(1253, (long) central.getProductionBaseForEnergy());
	}

	@Test
	public void testCostFormula() {
		SolarCentral central = new SolarCentral();

		{
			central.setLevel(7);
			ResourceSet cost = central.getNextLevelCost();
			assertEquals(1281, (long) cost.metal.getAmount());
			assertEquals(512, (long) cost.crystal.getAmount());
			assertEquals(0, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
	}
}
