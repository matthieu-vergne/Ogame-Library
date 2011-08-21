package org.ogameoptimizer.ogame.building;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public abstract class BuildingTest {

	abstract public Building createBuilding();

	@Test
	public void testLevel() {
		Building building = createBuilding();
		assertEquals(0, (long) building.getLevel());

		building.setLevel(5);
		assertEquals(5, (long) building.getLevel());
	}

	@Test
	public void testPersistence() {
		File file = new File("persistence");
		file.deleteOnExit();
		Building building = createBuilding();
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(building);
			out.close();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		
		Building building2 = null;
		
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fis);
			building2 = (Building) in.readObject();
			in.close();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		file.delete();
		
		assertNotNull(building2);
		assertEquals(building.getLevel(), building2.getLevel());
		assertNotNull(building2.getPlanet());
		assertEquals(building.getPlanet().getName(), building2.getPlanet().getName());
	}
}
