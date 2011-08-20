package org.ogameoptimizer.ogame.building.resources;

import org.ogameoptimizer.ogame.building.Building;
import org.ogameoptimizer.ogame.resource.IProducer;

public abstract class Producer extends Building implements IProducer {
	private Long energy = 0L;
	private Double productionRate = 1.0;

	@Override
	public Double getMaximumProductionRate() {
		return productionRate;
	}

	@Override
	public void setMaximumProductionRate(Double rate) {
		this.productionRate = rate;
	}

	@Override
	public Double getActualProductionRate() {
		return Math.max(
				0,
				Math.min(getMaximumProductionRate(), (double) getActualEnergy()
						/ -getProductionBaseForEnergy()));
	}

	public Long getActualEnergy() {
		return energy;
	}

	public void setActualEnergy(Long energy) {
		this.energy = energy;
	}

}
