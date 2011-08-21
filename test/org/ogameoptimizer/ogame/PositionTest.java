package org.ogameoptimizer.ogame;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;


public class PositionTest {
	@Test
	public void testPersistence() {
		File file = new File("persistence");
		file.deleteOnExit();
		Position position = new Position(1, 321, 14);
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(position);
			out.close();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		
		Position position2 = null;
		
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fis);
			position2 = (Position) in.readObject();
			in.close();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		file.delete();
		
		assertNotNull(position2);
		assertEquals(position.getGalaxy(), position2.getGalaxy());
		assertEquals(position.getSystem(), position2.getSystem());
		assertEquals(position.getRank(), position2.getRank());
	}

}
