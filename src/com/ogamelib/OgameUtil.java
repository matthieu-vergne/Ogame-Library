package com.ogamelib;

import java.util.Random;

public class OgameUtil {
	private final OgameData data;
	private final Random rand = new Random();

	public OgameUtil(OgameData data) {
		this.data = data;
	}

	public Position makeRandomPosition() {
		int galaxy = rand.nextInt(getData().getGalaxyAmount()) + 1;
		int system = rand.nextInt(getData().getSystemAmount()) + 1;
		int rank = rand.nextInt(getData().getRankAmount()) + 1;
		return new Position(galaxy, system, rank);
	}

	public Planet makeRandomPlanet() {
		return makeRandomPlanetForPosition(makeRandomPosition());
	}

	public Planet makeRandomPlanetForPosition(Position position) {
		int[] temperature = computeTemperatureMinAverageForRank(position
				.getRank());
		int size = computeSizeForPlanetAtRank(position.getRank());
		return new Planet(size, temperature[0], temperature[1], position);
	}

	private int[] computeTemperatureMinAverageForRank(int rank) {
		// FIXME test with reliable data
		int maxAverage = data.getMaxTemperaturesAverage(rank);
		int minAverage = maxAverage - 70;
		int maxTemp = maxAverage + rand.nextInt(20) - 10;
		int minTemp = minAverage + rand.nextInt(20) - 10;
		int[] temperature = new int[] { minTemp, (minTemp + maxTemp) / 2 };
		return temperature;
	}

	public int computeSizeForPlanetAtRank(int rank) {
		double min = data.getPlanetSizeMin(rank);
		double max = data.getPlanetSizeMax(rank);

		// FIXME compute as a linear function, but seems to not be one
		double a = (max - min) / 0.8;
		double b = min - a * 0.1;
		double x = rand.nextDouble();
		int size = (int) Math.floor(a * x + b);
		return size;
	}

	public OgameData getData() {
		return data;
	}
}
