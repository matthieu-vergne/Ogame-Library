package org.ogameoptimizer.ogame.resource;

import java.io.Serializable;

public interface IProducer extends Serializable {

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
