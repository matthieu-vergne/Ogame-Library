package com.ogamelib.resource;

import com.ogamelib.resource.AbstractResource;
import com.ogamelib.resource.Energy;


public class EnergyTest extends AbstractResourceTest {

	@Override
	public AbstractResource createAbstractResource() {
		return new Energy();
	}

}
