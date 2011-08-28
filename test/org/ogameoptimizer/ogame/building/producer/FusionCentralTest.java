package org.ogameoptimizer.ogame.building.producer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.ogameoptimizer.ogame.Planet;
import org.ogameoptimizer.ogame.building.producer.FusionCentral;
import org.ogameoptimizer.ogame.building.producer.Producer;
import org.ogameoptimizer.ogame.resource.ResourceSet;

public class FusionCentralTest extends ProducerTest {

	@Override
	public Producer createProducer() {
		FusionCentral central = new FusionCentral();
		central.setPlanet(new Planet());
		return central;
	}

	@Test
	public void testProductionFormula() {
		FusionCentral central = new FusionCentral();
		central.setPlanet(new Planet());

		central.setLevel(1);
		assertEquals(31, (long) central.getProductionBaseForEnergy());

		central.setLevel(5);
		assertEquals(191, (long) central.getProductionBaseForEnergy());

		central.setLevel(10);
		assertEquals(488, (long) central.getProductionBaseForEnergy());

		central.setLevel(15);
		assertEquals(935, (long) central.getProductionBaseForEnergy());
	}

	@Test
	public void testDeuteriumFormula() {
		FusionCentral central = new FusionCentral();

		central.setLevel(1);
		assertEquals(-11, (long) central.getProductionBaseForDeuterium());

		central.setLevel(5);
		assertEquals(-81, (long) central.getProductionBaseForDeuterium());

		central.setLevel(10);
		assertEquals(-260, (long) central.getProductionBaseForDeuterium());

		central.setLevel(15);
		assertEquals(-627, (long) central.getProductionBaseForDeuterium());
	}

	@Test
	public void testCostFormula() {
		FusionCentral central = new FusionCentral();

		{
			central.setLevel(0);
			ResourceSet cost = central.getNextLevelCost();
			assertEquals(900, (long) cost.metal.getAmount());
			assertEquals(360, (long) cost.crystal.getAmount());
			assertEquals(180, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}

		{
			central.setLevel(3);
			ResourceSet cost = central.getNextLevelCost();
			assertEquals(5248, (long) cost.metal.getAmount());
			assertEquals(2099, (long) cost.crystal.getAmount());
			assertEquals(1049, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}
		
		// TODO complete with other levels
	}
}
