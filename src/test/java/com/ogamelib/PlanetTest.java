package com.ogamelib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import com.ogamelib.Planet;
import com.ogamelib.Position;
import com.ogamelib.User;
import com.ogamelib.building.Building;
import com.ogamelib.technology.Technology;

public class PlanetTest {

	@Test
	public void testName() {
		Planet planet = new Planet();

		{
			String name = "aze";
			planet.setName(name);
			assertEquals(name, planet.getName());
		}

		{
			String name = "xdv574sf45";
			planet.setName(name);
			assertEquals(name, planet.getName());
		}
	}

	@Test
	public void testOwner() {
		Planet planet = new Planet();
		assertNull(planet.getOwner());

		{
			User owner = new User();
			planet.setOwner(owner);
			assertEquals(owner, planet.getOwner());
		}

		{
			User owner = new User();
			planet.setOwner(owner);
			assertEquals(owner, planet.getOwner());
		}
	}

	@Test
	public void testPersistence() {
		File file = new File("persistence");
		//file.deleteOnExit();
		Planet planet = new Planet();
		planet.setName("Pythagore");
		planet.setDiameter(50000);
		planet.setPosition(new Position(2, 54, 1));
		planet.setTemperatureAverage(20);
		planet.setTemperatureMin(-20);
		planet.getBuildings().metalMine.setLevel(5);
		planet.getBuildings().crystalMine.setLevel(4);
		planet.getBuildings().solarCentral.setLevel(4);
		planet.getMetal().setAmount(100L);
		planet.getCrystal().setAmount(200L);
		planet.getDeuterium().setAmount(300L);
		planet.getAntimatter().setAmount(400L);
		planet.getEnergy().setAmount(500L);

		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(planet);
			out.close();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}

		Planet planet2 = null;

		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fis);
			planet2 = (Planet) in.readObject();
			in.close();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		//file.delete();

		assertNotNull(planet2);
		assertEquals(planet.getName(), planet2.getName());
		assertEquals(planet.getDiameter(), planet2.getDiameter());
		assertEquals(planet.getTemperatureAverage(), planet2.getTemperatureAverage());
		assertEquals(planet.getTemperatureMin(), planet2.getTemperatureMin());
		assertEquals(planet.getPosition(), planet2.getPosition());
		assertEquals(planet.getMetal().getAmount(), planet2.getMetal().getAmount());
		assertEquals(planet.getCrystal().getAmount(), planet2.getCrystal().getAmount());
		assertEquals(planet.getDeuterium().getAmount(), planet2.getDeuterium().getAmount());
		assertEquals(planet.getAntimatter().getAmount(), planet2.getAntimatter().getAmount());
		assertEquals(planet.getEnergy().getAmount(), planet2.getEnergy().getAmount());
		assertEquals(planet.getOwner(), planet2.getOwner());
		assertNotNull(planet2.getBuildings());
		assertEquals(planet.getBuildings().toBuildingArray().length,
				planet2.getBuildings().toBuildingArray().length);
		for (Building b1 : planet.getBuildings()) {
			for (Building b2 : planet2.getBuildings()) {
				if (b2.getClass().equals(b1.getClass())) {
					assertEquals(b1.getLevel(), b2.getLevel());
					break;
				}
			}
		}
		
		for(Building building : planet2.getBuildings()) {
			assertEquals(planet2, building.getPlanet());
		}
		
		for (Technology t1 : planet.getTechnologies()) {
			for (Technology t2 : planet2.getTechnologies()) {
				if (t2.getClass().equals(t1.getClass())) {
					assertEquals(t1.getLevel(), t2.getLevel());
					break;
				}
			}
		}
	}
}
