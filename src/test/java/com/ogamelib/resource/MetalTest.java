package com.ogamelib.resource;

import com.ogamelib.resource.AbstractResource;
import com.ogamelib.resource.Metal;


public class MetalTest extends AbstractResourceTest {

	@Override
	public AbstractResource createAbstractResource() {
		return new Metal();
	}

}
