package org.ogameoptimizer.ogame.resource;

public abstract class AbstractResourceTest extends ResourceTest {
	abstract public AbstractResource createAbstractResource();

	@Override
	public Resource createResource() {
		return createAbstractResource();
	}
}
