package org.ogameoptimizer.ogame.resource;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class NaturalProducer implements IProducer {

	private static NaturalProducer instance = null;

	public static NaturalProducer getInstance() {
		if (instance == null) {
			instance = new NaturalProducer();
		}
		return instance;
	}

	@Override
	public Long getProductionBaseForMetal() {
		return 30L;
	}

	@Override
	public Long getProductionBaseForCrystal() {
		return 15L;
	}

	@Override
	public Long getProductionBaseForDeuterium() {
		return 0L;
	}

	@Override
	public Long getProductionBaseForAntimatter() {
		return 0L;
	}

	@Override
	public Long getProductionBaseForEnergy() {
		return 0L;
	}

	@Override
	public Double getActualProductionRate() {
		return 1.0;
	}

	@Override
	public Double getMaximumProductionRate() {
		return 1.0;
	}

	@Override
	public void setMaximumProductionRate(Double rate) {
		throw new IllegalStateException(
				"You cannot change the rate of production of the planet.");
	}

	private static final long serialVersionUID = 1L;

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// nothing to write
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		// nothing to read
	}
}
