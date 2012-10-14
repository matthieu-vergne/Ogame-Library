package com.ogamelib;

import java.util.Random;

public class OgameUtil {
	private final OgameData data;
	private final Random rand = new Random();

	public OgameUtil(OgameData data) {
		this.data = data;
	}

	public Position makeRandomPosition() {
		int galaxy = rand.nextInt(data.getGalaxyAmount()) + 1;
		int system = rand.nextInt(data.getSystemAmount()) + 1;
		int rank = rand.nextInt(data.getRankAmount()) + 1;
		return new Position(galaxy, system, rank);
	}

	public Planet makeRandomPlanet() {
		return makeRandomPlanetForPosition(makeRandomPosition());
	}

	public Planet makeRandomPlanetForPosition(Position position) {
		int[] temperature = data.getTemperatureComputer().compute(position.getRank());
		int size = data.getPlanetSizeComputer().compute(position.getRank());
		return new Planet(size, temperature[0], temperature[1], position);
	}

	public OgameData getData() {
		return data;
	}
}
