package org.ogameoptimizer.ogame.resource;

import java.io.Serializable;

public interface Resource extends Serializable {
	public Long getActualAmount();
	public void setActualAmount(Long actualAmount);
}
