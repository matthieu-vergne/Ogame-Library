package org.ogameoptimizer.ogame.building.resources;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.ogameoptimizer.ogame.building.Building;
import org.ogameoptimizer.ogame.building.BuildingTest;

public abstract class ProducerTest extends BuildingTest {

	abstract public Producer createProducer();

	@Override
	public Building createBuilding() {
		return createProducer();
	}

	@Test
	public void testActualEnergy() {
		Producer producer = createProducer();
		assertEquals(0, (long) producer.getActualEnergy());

		producer.setActualEnergy(50L);
		assertEquals(50, (long) producer.getActualEnergy());
	}

	@Test
	public void testProductionControl() {
		Producer producer = createProducer();
		producer.setActualEnergy(Long.MAX_VALUE);
		assertEquals(1, (double) producer.getMaximumProductionRate(), 0);
		assertEquals(producer.getMaximumProductionRate(),
				(double) producer.getActualProductionRate(), 0);

		producer.setMaximumProductionRate(5.0);
		assertEquals(5.0, (double) producer.getMaximumProductionRate(), 0);
		assertEquals(producer.getMaximumProductionRate(),
				(double) producer.getActualProductionRate(), 0);

		producer.setMaximumProductionRate(0.0);
		assertEquals(0.0, (double) producer.getMaximumProductionRate(), 0);
		assertEquals(producer.getMaximumProductionRate(),
				(double) producer.getActualProductionRate(), 0);
	}
	
	@Test
	public void testIProducerConstraints() {
		// TODO add the tests of the IProducer interface
	}
}
