package org.ogameoptimizer.ogame.building.resources;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.ogameoptimizer.ogame.building.Building;
import org.ogameoptimizer.ogame.resource.IProducer;

public abstract class Producer extends Building implements IProducer {
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

	private Long energy = 0L;

	public Long getActualEnergy() {
		return energy;
	}

	public void setActualEnergy(Long energy) {
		this.energy = energy;
	}

	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		super.writeExternal(out);
		out.writeDouble(productionRate);
		out.writeLong(energy);
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException,
	ClassNotFoundException {
		super.readExternal(in);
		productionRate = in.readDouble();
		energy = in.readLong();
	}
}
