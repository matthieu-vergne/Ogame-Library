package org.ogameoptimizer.ogame.resource;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class ResourceTest {

	abstract public Resource createResource();

	@Test
	public void testActualAmount() {
		Resource resource = createResource();
		assertEquals(0, (long) resource.getAmount());

		resource.setAmount(500L);
		assertEquals(500, (long) resource.getAmount());
	}
}
