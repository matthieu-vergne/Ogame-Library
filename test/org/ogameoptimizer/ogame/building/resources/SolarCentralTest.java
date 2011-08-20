package org.ogameoptimizer.ogame.building.resources;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

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
}
