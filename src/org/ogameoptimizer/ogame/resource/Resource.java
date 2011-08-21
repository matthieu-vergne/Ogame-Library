package org.ogameoptimizer.ogame.resource;

import java.io.Externalizable;

public interface Resource extends Externalizable {
	public Long getActualAmount();
	public void setActualAmount(Long actualAmount);
}
