package org.ogameoptimizer.ogame.resource;


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

}
