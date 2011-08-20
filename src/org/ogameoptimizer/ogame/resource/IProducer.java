package org.ogameoptimizer.ogame.resource;

public interface IProducer {

	public Double getMaximumProductionRate();
	public void setMaximumProductionRate(Double rate);
	public Double getActualProductionRate();
	
	/**
	 * @see http://www.aideogame.fr/formules-ogamiennes-faq-ogame.htm
	 */
	public abstract Long getProductionBaseForMetal();

	/**
	 * @see http://www.aideogame.fr/formules-ogamiennes-faq-ogame.htm
	 */
	public abstract Long getProductionBaseForCrystal();

	/**
	 * @see http://www.aideogame.fr/formules-ogamiennes-faq-ogame.htm
	 */
	public abstract Long getProductionBaseForDeuterium();

	/**
	 * @see http://www.aideogame.fr/formules-ogamiennes-faq-ogame.htm
	 */
	public abstract Long getProductionBaseForAntimatter();

	/**
	 * @see http://www.aideogame.fr/formules-ogamiennes-faq-ogame.htm
	 */
	public abstract Long getProductionBaseForEnergy();
}
