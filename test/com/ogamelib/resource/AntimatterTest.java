package com.ogamelib.resource;

import com.ogamelib.resource.AbstractResource;
import com.ogamelib.resource.Antimatter;


public class AntimatterTest extends AbstractResourceTest {

	@Override
	public AbstractResource createAbstractResource() {
		return new Antimatter();
	}

}
