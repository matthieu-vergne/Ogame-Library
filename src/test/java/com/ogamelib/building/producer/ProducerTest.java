package com.ogamelib.building.producer;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import com.ogamelib.Planet;
import com.ogamelib.Position;
import com.ogamelib.building.Building;
import com.ogamelib.building.BuildingTest;
import com.ogamelib.resource.IProducerTest;

public abstract class ProducerTest extends BuildingTest {

	abstract public Producer createProducer();

	class IProducer extends IProducerTest {
		@Override
		public com.ogamelib.resource.IProducer createIProducer() {
			return createProducer();
		}
	}

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

	@Test
	public void testPersistence() {
		File file = new File("producer");
		file.deleteOnExit();
		Producer producer = createProducer();
		producer.setPlanet(new Planet(15000, -30, 12, new Position(5, 21, 3)));

		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(producer);
			out.close();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}

		Producer producer2 = null;

		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fis);
			producer2 = (Producer) in.readObject();
			in.close();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		file.delete();

		assertNotNull(producer2);
		assertEquals(producer.getActualEnergy(), producer2.getActualEnergy());
		assertEquals(producer.getActualProductionRate(),
				producer2.getActualProductionRate());
		assertEquals(producer.getLevel(), producer2.getLevel());
		assertNotNull(producer2.getPlanet());
		assertEquals(producer.getPlanet().getPosition(), producer2.getPlanet()
				.getPosition());
	}
}
