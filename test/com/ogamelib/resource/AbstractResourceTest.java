package com.ogamelib.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import com.ogamelib.resource.AbstractResource;
import com.ogamelib.resource.Resource;

public abstract class AbstractResourceTest extends ResourceTest {
	abstract public AbstractResource createAbstractResource();

	@Override
	public Resource createResource() {
		return createAbstractResource();
	}
	@Test
	public void testPersistence() {
		File file = new File("producer");
		file.deleteOnExit();
		AbstractResource resource = createAbstractResource();
		
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(resource);
			out.close();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		
		AbstractResource resource2 = null;
		
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream in = new ObjectInputStream(fis);
			resource2 = (AbstractResource) in.readObject();
			in.close();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		file.delete();
		
		assertNotNull(resource2);
		assertEquals(resource.getAmount(), resource2.getAmount());
	}
}
