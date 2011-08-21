package org.ogameoptimizer.ogame.resource;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public abstract class AbstractResource implements Resource {

	private Long actualAmount = 0L;

	@Override
	public Long getActualAmount() {
		return actualAmount;
	}

	@Override
	public void setActualAmount(Long actualAmount) {
		this.actualAmount = actualAmount;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeLong(actualAmount);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		actualAmount = in.readLong();
	}
}
