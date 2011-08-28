package org.ogameoptimizer.ogame.resource;

import org.junit.Test;
import static org.junit.Assert.*;


public abstract class IProducerTest {
	
	public abstract IProducer createIProducer();
	
	@Test
	public void testProductionRate() {
		IProducer producer = createIProducer();
		
		producer.setMaximumProductionRate(5.0);
		assertEquals(5.0, (double) producer.getMaximumProductionRate(), 0);

		producer.setMaximumProductionRate(0.0);
		assertEquals(0.0, (double) producer.getMaximumProductionRate(), 0);
	}

	@Test
	public void testFail() {
		fail("force fail");
	}

}
