package org.ogameoptimizer.ogame;

import java.util.ArrayList;
import java.util.Collection;

public class User {
	private final Collection<Planet> planets = new ArrayList<Planet>();
	private String name = "user";

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

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
