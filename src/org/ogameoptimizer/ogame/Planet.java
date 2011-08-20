package org.ogameoptimizer.ogame;

import java.util.ArrayList;
import java.util.Collection;

import org.ogameoptimizer.ogame.building.Building;
import org.ogameoptimizer.ogame.building.resources.Producer;
import org.ogameoptimizer.ogame.resource.Antimatter;
import org.ogameoptimizer.ogame.resource.Crystal;
import org.ogameoptimizer.ogame.resource.Deuterium;
import org.ogameoptimizer.ogame.resource.Energy;
import org.ogameoptimizer.ogame.resource.IProducer;
import org.ogameoptimizer.ogame.resource.Metal;
import org.ogameoptimizer.ogame.resource.NaturalProducer;

public class Planet {
	private final Long diameter;
	private final Integer temperatureMin;
	private final Integer temperatureMax;
	private final Position position;
	private final Metal metal = new Metal();
	private final Crystal crystal = new Crystal();
	private final Deuterium deuterium = new Deuterium();
	private final Antimatter antimatter = new Antimatter();
	private final Energy energy = new Energy();
	private final Collection<Building> buildings = new ArrayList<Building>();
	private User owner = null;
	private String name = "Planet";

	/**
	 * Create a basic planet :
	 * <ul>
	 * <li>with a diameter of 12.800km</li>
	 * <li>with a temperature between -32°C and 8°C</li>
	 * <li>at the position [4:358:12]</li>
	 * </ul>
	 * This data is an example of mother planet.
	 */
	public Planet() {
		this(12800L, -32, 8, new Position(4, 358, 12));
	}

	public Planet(Long diameter, Integer temperatureMin,
			Integer temperatureMax, Position position) {
		this.diameter = diameter;
		this.temperatureMin = temperatureMin;
		this.temperatureMax = temperatureMax;
		this.position = position;
	}

	public Metal getMetal() {
		return metal;
	}

	public Crystal getCrystal() {
		return crystal;
	}

	public Deuterium getDeuterium() {
		return deuterium;
	}

	public Antimatter getAntimatter() {
		return antimatter;
	}

	public Energy getEnergy() {
		return energy;
	}

	public Building[] getBuildings() {
		return buildings.toArray(new Building[0]);
	}

	public void addBuilding(Building building) {
		buildings.add(building);
		if (building instanceof Producer) {
			updateEnergy();
		}
	}

	public void updateEnergy() {
		Long producedEnergy = 0L;
		Long consumedEnergy = 0L;
		for (IProducer producer : getProducers(false)) {
			Long energy = (long) Math.floor(producer
					.getProductionBaseForEnergy()
					* producer.getMaximumProductionRate());
			if (energy > 0) {
				producedEnergy += energy;
			} else {
				consumedEnergy += energy;
			}
		}

		getEnergy().setActualAmount(producedEnergy - consumedEnergy);

		Double rate = Math.min(1, (double) producedEnergy / consumedEnergy);
		for (IProducer producer : getProducers(true)) {
			Producer building = (Producer) producer;
			Long energy = building.getProductionBaseForEnergy();
			if (energy < 0) {
				Long givenEnergy = (long) Math.round(energy * rate);
				building.setActualEnergy(givenEnergy);
			}
		}
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public User getOwner() {
		return owner;
	}

	public Long getDiameter() {
		return diameter;
	}

	public Integer getTemperatureMin() {
		return temperatureMin;
	}

	public Integer getTemperatureMax() {
		return temperatureMax;
	}

	public Position getPosition() {
		return position;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public IProducer[] getProducers(Boolean onlyBuildings) {
		Collection<IProducer> producers = new ArrayList<IProducer>();
		for (Building building : getBuildings()) {
			if (building instanceof IProducer) {
				producers.add((IProducer) building);
			}
		}
		if (!onlyBuildings) {
			producers.add(NaturalProducer.getInstance());
		}
		return producers.toArray(new IProducer[producers.size()]);
	}
}
