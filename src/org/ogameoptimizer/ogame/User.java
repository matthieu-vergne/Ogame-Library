package org.ogameoptimizer.ogame;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Collection;

public class User implements Externalizable {
	private final Collection<Planet> planets = new ArrayList<Planet>();

	public Planet[] getPlanets() {
		return planets.toArray(new Planet[planets.size()]);
	}

	public void acquirePlanet(Planet planet) {
		planet.setOwner(this);
		planets.add(planet);
	}

	public void destroyPlanet(Planet planet) {
		planets.remove(planet);
		planet.setOwner(null);
	}

	private String name = "user";

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeUTF(name);
		out.writeInt(planets.size());
		for (Planet planet : planets) {
			out.writeObject(planet);
		}
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		name = in.readUTF();
		int planetCounter = in.readInt();
		while (planetCounter > 0) {
			Planet planet = (Planet) in.readObject();
			planet.setOwner(this);
			planets.add(planet);
			planetCounter--;
		}
	}
}
