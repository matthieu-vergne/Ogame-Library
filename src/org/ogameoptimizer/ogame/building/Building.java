package org.ogameoptimizer.ogame.building;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.ogameoptimizer.ogame.Planet;
import org.ogameoptimizer.ogame.resource.ResourceSet;

public abstract class Building implements Externalizable {

	private Integer level = 0;
	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	private Planet planet = null;
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}

	public Planet getPlanet() {
		return planet;
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(level);
		out.writeObject(planet);
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		level = in.readInt();
		planet = (Planet) in.readObject();
	}
	
	abstract public ResourceSet getNextLevelCost();
}
