package org.ogameoptimizer.ogame;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Collection;

import org.ogameoptimizer.ogame.building.Building;
import org.ogameoptimizer.ogame.building.BuildingSet;
import org.ogameoptimizer.ogame.building.resources.Producer;
import org.ogameoptimizer.ogame.resource.Antimatter;
import org.ogameoptimizer.ogame.resource.Crystal;
import org.ogameoptimizer.ogame.resource.Deuterium;
import org.ogameoptimizer.ogame.resource.Energy;
import org.ogameoptimizer.ogame.resource.IProducer;
import org.ogameoptimizer.ogame.resource.Metal;
import org.ogameoptimizer.ogame.resource.NaturalProducer;

public class Planet implements Externalizable {

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
		buildings.setPlanet(this);
	}

	private final Metal metal = new Metal();

	public Metal getMetal() {
		return metal;
	}

	private final Crystal crystal = new Crystal();

	public Crystal getCrystal() {
		return crystal;
	}

	private final Deuterium deuterium = new Deuterium();

	public Deuterium getDeuterium() {
		return deuterium;
	}

	private final Antimatter antimatter = new Antimatter();

	public Antimatter getAntimatter() {
		return antimatter;
	}

	private final Energy energy = new Energy();

	public Energy getEnergy() {
		return energy;
	}

	private BuildingSet buildings = new BuildingSet();

	public BuildingSet getBuildings() {
		return buildings;
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

	private User owner = null;

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public User getOwner() {
		return owner;
	}

	private Long diameter;

	public void setDiameter(Long diameter) {
		this.diameter = diameter;
	}

	public Long getDiameter() {
		return diameter;
	}

	private Integer temperatureMin;

	public void setTemperatureMin(Integer temperatureMin) {
		this.temperatureMin = temperatureMin;
	}

	public Integer getTemperatureMin() {
		return temperatureMin;
	}

	private Integer temperatureMax;

	public void setTemperatureMax(Integer temperatureMax) {
		this.temperatureMax = temperatureMax;
	}

	public Integer getTemperatureMax() {
		return temperatureMax;
	}

	private Position position;

	public void setPosition(Position position) {
		this.position = position;
	}

	public Position getPosition() {
		return position;
	}

	private String name = "Planet";

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

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeLong(diameter);
		out.writeInt(temperatureMin);
		out.writeInt(temperatureMax);
		out.writeObject(position);
		out.writeObject(owner);
		out.writeUTF(name);
		out.writeLong(metal.getActualAmount());
		out.writeLong(crystal.getActualAmount());
		out.writeLong(deuterium.getActualAmount());
		out.writeLong(antimatter.getActualAmount());
		out.writeLong(energy.getActualAmount());
		out.writeObject(buildings);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		diameter = in.readLong();
		temperatureMin = in.readInt();
		temperatureMax = in.readInt();
		position = (Position) in.readObject();
		owner = (User) in.readObject();
		name = in.readUTF();
		metal.setActualAmount(in.readLong());
		crystal.setActualAmount(in.readLong());
		deuterium.setActualAmount(in.readLong());
		antimatter.setActualAmount(in.readLong());
		energy.setActualAmount(in.readLong());
		buildings = (BuildingSet) in.readObject();
	}
}
