package com.ogamelib;

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


public abstract class LeveledElementTest {

	public abstract LeveledElement createLeveledElement();
	
	@Test
	public void testLevel() {
		LeveledElement element = createLeveledElement();
		assertEquals(0, (long) element.getLevel());

		element.setLevel(5);
		assertEquals(5, (long) element.getLevel());
	}


	@Test
	public void testPersistence() {
		File file = new File("persistence");
		file.deleteOnExit();
		LeveledElement element = createLeveledElement();
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(element);
			out.close();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		
		LeveledElement element2 = null;
		
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fis);
			element2 = (LeveledElement) in.readObject();
			in.close();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		file.delete();
		
		assertNotNull(element2);
		assertEquals(element.getLevel(), element2.getLevel());
	}
}
