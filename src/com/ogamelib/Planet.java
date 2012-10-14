package com.ogamelib;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Collection;

import com.ogamelib.building.Building;
import com.ogamelib.building.BuildingSet;
import com.ogamelib.building.producer.Producer;
import com.ogamelib.resource.Antimatter;
import com.ogamelib.resource.Crystal;
import com.ogamelib.resource.Deuterium;
import com.ogamelib.resource.Energy;
import com.ogamelib.resource.IProducer;
import com.ogamelib.resource.Metal;
import com.ogamelib.resource.NaturalProducer;
import com.ogamelib.technology.TechnologySet;

//TODO create spaceships
//TODO create defense
public class Planet implements Externalizable {

	public Planet() {
		this(null, null, null, null);
	}

	public Planet(Integer diameter, Integer temperatureMin,
			Integer temperatureAverage, Position position) {
		this.diameter = diameter;
		this.temperatureMin = temperatureMin;
		this.temperatureAverage = temperatureAverage;
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

	private TechnologySet technologies = new TechnologySet();

	public TechnologySet getTechnologies() {
		return technologies;
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

		getEnergy().setAmount(producedEnergy - consumedEnergy);

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

	private Integer diameter;

	public void setDiameter(Integer diameter) {
		this.diameter = diameter;
	}

	public Integer getDiameter() {
		return diameter;
	}

	private Integer temperatureMin;

	public void setTemperatureMin(Integer temperatureMin) {
		this.temperatureMin = temperatureMin;
	}

	public Integer getTemperatureMin() {
		return temperatureMin;
	}

	private Integer temperatureAverage;

	public void setTemperatureAverage(Integer temperatureAverage) {
		this.temperatureAverage = temperatureAverage;
	}

	public Integer getTemperatureAverage() {
		return temperatureAverage;
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
		out.writeInt(diameter);
		out.writeInt(temperatureMin);
		out.writeInt(temperatureAverage);
		out.writeObject(position);
		out.writeObject(owner);
		out.writeUTF(name);
		out.writeLong(metal.getAmount());
		out.writeLong(crystal.getAmount());
		out.writeLong(deuterium.getAmount());
		out.writeLong(antimatter.getAmount());
		out.writeLong(energy.getAmount());
		out.writeObject(buildings);
		out.writeObject(technologies);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		diameter = in.readInt();
		temperatureMin = in.readInt();
		temperatureAverage = in.readInt();
		position = (Position) in.readObject();
		owner = (User) in.readObject();
		name = in.readUTF();
		metal.setAmount(in.readLong());
		crystal.setAmount(in.readLong());
		deuterium.setAmount(in.readLong());
		antimatter.setAmount(in.readLong());
		energy.setAmount(in.readLong());
		buildings = (BuildingSet) in.readObject();
		technologies = (TechnologySet) in.readObject();
	}

	@Override
	public String toString() {
		return getName() + " " + getPosition();
	}
}
