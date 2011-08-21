package org.ogameoptimizer.ogame.resource;

import java.io.Externalizable;

public interface Resource extends Externalizable {
	public Long getAmount();
	public void setAmount(Long actualAmount);
}
