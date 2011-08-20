package org.ogameoptimizer.ogame.building;

import org.ogameoptimizer.ogame.Planet;

public abstract class Building {
	private Integer level = 1;
	private Planet planet = null;

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public void setPlanet(Planet planet) {
		this.planet = planet;
	}

	public Planet getPlanet() {
		return planet;
	}

}
