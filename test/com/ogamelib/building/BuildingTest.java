package com.ogamelib.building;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import com.ogamelib.LeveledElement;
import com.ogamelib.LeveledElementTest;
import com.ogamelib.Planet;
import com.ogamelib.building.Building;

public abstract class BuildingTest extends LeveledElementTest {

	abstract public Building createBuilding();
	
	@Override
	public LeveledElement createLeveledElement() {
		return createBuilding();
	}

	@Test
	public void testPersistence() {
		File file = new File("persistence");
		file.deleteOnExit();
		Building building = createBuilding();
		if (building.getPlanet() == null) {
			building.setPlanet(new Planet());
		}
		
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
		if (building.getPlanet() != null) {
			assertNotNull(building2.getPlanet());
			assertEquals(building.getPlanet().getPosition(), building2.getPlanet().getPosition());
		}
	}
}
