package org.ogameoptimizer.ogame.resource;

public class NaturalProducer implements IProducer {

	private static final long serialVersionUID = 1L;
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
}
