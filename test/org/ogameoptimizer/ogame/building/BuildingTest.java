package org.ogameoptimizer.ogame.building;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class BuildingTest {

	abstract public Building createBuilding();

	@Test
	public void testLevel() {
		Building building = createBuilding();
		assertEquals(1, (long) building.getLevel());

		building.setLevel(5);
		assertEquals(5, (long) building.getLevel());
	}

}
