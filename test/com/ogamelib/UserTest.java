package com.ogamelib;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import org.junit.Test;

import com.ogamelib.Planet;
import com.ogamelib.Position;
import com.ogamelib.User;
import com.ogamelib.building.Building;
import com.ogamelib.technology.Technology;

public class UserTest {

	@Test
	public void testPlanet() {
		User user = new User();
		assertEquals(0, user.getPlanets().length);

		Planet p1 = new Planet();
		user.acquirePlanet(p1);
		assertEquals(1, user.getPlanets().length);
		assertTrue(Arrays.asList(user.getPlanets()).contains(p1));

		Planet p2 = new Planet();
		user.acquirePlanet(p2);
		assertEquals(2, user.getPlanets().length);
		assertTrue(Arrays.asList(user.getPlanets()).contains(p1));
		assertTrue(Arrays.asList(user.getPlanets()).contains(p2));

		user.destroyPlanet(p1);
		assertEquals(1, user.getPlanets().length);
		assertTrue(Arrays.asList(user.getPlanets()).contains(p2));

		user.destroyPlanet(p2);
		assertEquals(0, user.getPlanets().length);
	}

	@Test
	public void testName() {
		User user = new User();

		{
			String name = "aze";
			user.setName(name);
			assertEquals(name, user.getName());
		}

		{
			String name = "sf564sf54sdf46";
			user.setName(name);
			assertEquals(name, user.getName());
		}
	}

	@Test
	public void testPersistence() {
		File file = new File("persistence");
		file.deleteOnExit();
		User user = new User();
		user.setName("Avogadro");
		
		{
			Planet planet = new Planet();
			planet.setName("Pythagore");
			planet.setDiameter(500000);
			planet.setPosition(new Position(3, 45, 7));
			planet.setTemperatureAverage(40);
			planet.setTemperatureMin(-10);
			planet.getBuildings().metalMine.setLevel(5);
			planet.getBuildings().crystalMine.setLevel(5);
			planet.getBuildings().solarCentral.setLevel(5);
			planet.getMetal().setAmount(100L);
			planet.getCrystal().setAmount(200L);
			planet.getDeuterium().setAmount(300L);
			planet.getAntimatter().setAmount(400L);
			planet.getEnergy().setAmount(500L);
			user.acquirePlanet(planet);
		}

		{
			Planet planet = new Planet();
			planet.setName("Al-Kashi");
			planet.setDiameter(50000);
			planet.setPosition(new Position(2, 54, 1));
			planet.setTemperatureAverage(20);
			planet.setTemperatureMin(-20);
			planet.getBuildings().metalMine.setLevel(5);
			planet.getBuildings().crystalMine.setLevel(4);
			planet.getBuildings().deuteriumMine.setLevel(3);
			planet.getBuildings().solarCentral.setLevel(6);
			planet.getMetal().setAmount(100L);
			planet.getCrystal().setAmount(200L);
			planet.getDeuterium().setAmount(300L);
			planet.getAntimatter().setAmount(0L);
			planet.getEnergy().setAmount(500L);
			user.acquirePlanet(planet);
		}

		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(user);
			out.close();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}

		User user2 = null;

		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fis);
			user2 = (User) in.readObject();
			in.close();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		file.delete();

		assertNotNull(user2);
		assertEquals(user.getName(), user2.getName());
		assertNotNull(user2.getPlanets());
		assertEquals(user.getPlanets().length, user2.getPlanets().length);
		for (Planet p1 : user.getPlanets()) {
			boolean isPresent = false;
			for (Planet p2 : user2.getPlanets()) {
				if (p2.getPosition().equals(p1.getPosition())) {
					isPresent = true;
					for (Building b1 : p1.getBuildings()) {
						for (Building b2 : p2.getBuildings()) {
							if (b2.getClass().equals(b1.getClass())) {
								assertEquals(b1.getLevel(), b2.getLevel());
								break;
							}
						}
					}
					for (Technology t1 : p1.getTechnologies()) {
						for (Technology t2 : p2.getTechnologies()) {
							if (t2.getClass().equals(t1.getClass())) {
								assertEquals(t1.getLevel(), t2.getLevel());
								break;
							}
						}
					}
					break;
				}
			}
			if (!isPresent) {
				fail(p1.getName() + " at " + p1.getPosition()
						+ " cannot be retrieved.");
			}
		}
		
		for(Planet planet : user2.getPlanets()) {
			assertEquals(user2, planet.getOwner());
			for(Building building : planet.getBuildings()) {
				assertEquals(planet, building.getPlanet());
			}
		}
	}
}
