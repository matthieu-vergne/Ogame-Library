package org.ogameoptimizer.ogame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;
import org.ogameoptimizer.ogame.building.Building;
import org.ogameoptimizer.ogame.building.resources.CrystalMine;
import org.ogameoptimizer.ogame.building.resources.MetalMine;

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
		planet.setDiameter(50000L);
		planet.setPosition(new Position(2, 54, 1));
		planet.setTemperatureMax(20);
		planet.setTemperatureMin(-20);
		planet.constructBuilding(new MetalMine());
		planet.constructBuilding(new CrystalMine());
		planet.getMetal().setActualAmount(100L);
		planet.getCrystal().setActualAmount(200L);
		planet.getDeuterium().setActualAmount(300L);
		planet.getAntimatter().setActualAmount(400L);
		planet.getEnergy().setActualAmount(500L);

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
		assertEquals(planet.getTemperatureMax(), planet2.getTemperatureMax());
		assertEquals(planet.getTemperatureMin(), planet2.getTemperatureMin());
		assertEquals(planet.getPosition(), planet2.getPosition());
		assertEquals(planet.getMetal().getActualAmount(), planet2.getMetal().getActualAmount());
		assertEquals(planet.getCrystal().getActualAmount(), planet2.getCrystal().getActualAmount());
		assertEquals(planet.getDeuterium().getActualAmount(), planet2.getDeuterium().getActualAmount());
		assertEquals(planet.getAntimatter().getActualAmount(), planet2.getAntimatter().getActualAmount());
		assertEquals(planet.getEnergy().getActualAmount(), planet2.getEnergy().getActualAmount());
		assertEquals(planet.getOwner(), planet2.getOwner());
		assertNotNull(planet2.getBuildings());
		assertEquals(planet.getBuildings().length,
				planet2.getBuildings().length);
		for (Building b1 : planet.getBuildings()) {
			Boolean isPresent = false;
			for (Building b2 : planet2.getBuildings()) {
				if (b2.getClass().equals(b1.getClass())) {
					isPresent = true;
					break;
				}
			}
			if (!isPresent) {
				fail(b1 + " has not been retrieved.");
			}
		}
		
		for(Building building : planet2.getBuildings()) {
			assertEquals(planet2, building.getPlanet());
		}
	}
}
