package org.ogameoptimizer.ogame;

import org.junit.Test;
import static org.junit.Assert.*;


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
}
