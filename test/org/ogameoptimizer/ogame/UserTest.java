package org.ogameoptimizer.ogame;

import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.*;


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
}
