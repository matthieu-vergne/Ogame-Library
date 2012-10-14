package com.ogamelib.building;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import com.ogamelib.LeveledElement;
import com.ogamelib.Planet;

public abstract class Building extends LeveledElement implements Externalizable {

	private Planet planet = null;
	public void setPlanet(Planet planet) {
		this.planet = planet;
	}

	public Planet getPlanet() {
		return planet;
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		super.writeExternal(out);
		out.writeObject(planet);
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		super.readExternal(in);
		planet = (Planet) in.readObject();
	}
	
}
