package com.ogamelib;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class OgameUtil {
	private final Random rand = new Random();

	private OgameUtil() {
		// forbidden constructor (to force the static instance use).
	}

	private static final OgameUtil instance = new OgameUtil();

	public static OgameUtil getInstance() {
		return instance;
	}

	public Position makeRandomPosition() {
		int galaxy = rand.nextInt(9) + 1;
		int system = rand.nextInt(499) + 1;
		int rank = rand.nextInt(15) + 1;
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
		int maxAverage = getMaxTemperaturesAverages().get(rank);
		int minAverage = maxAverage - 70;
		int maxTemp = maxAverage + rand.nextInt(20) - 10;
		int minTemp = minAverage + rand.nextInt(20) - 10;
		int[] temperature = new int[] { minTemp, (minTemp + maxTemp) / 2 };
		return temperature;
	}

	public int computeSizeForPlanetAtRank(int rank) {
		double min = getPlanetSizeMins().get(rank);
		double max = getPlanetSizeMaxs().get(rank);

		// FIXME compute as a linear function, but seems to not be one
		double a = (max - min) / 0.8;
		double b = min - a * 0.1;
		double x = rand.nextDouble();
		int size = (int) Math.floor(a * x + b);
		return size;
	}

	public Map<Integer, Integer> getMaxTemperaturesAverages() {
		Map<Integer, Integer> temperatures = new HashMap<Integer, Integer>();
		temperatures.put(1, 122);
		temperatures.put(2, 122);
		temperatures.put(3, 122);
		temperatures.put(4, 65);
		temperatures.put(5, 65);
		temperatures.put(6, 65);
		temperatures.put(7, 35);
		temperatures.put(8, 35);
		temperatures.put(9, 35);
		temperatures.put(10, 15);
		temperatures.put(11, 15);
		temperatures.put(12, 15);
		temperatures.put(13, -40);
		temperatures.put(14, -40);
		temperatures.put(15, -40);
		return temperatures;
	}

	public Map<Integer, Integer> getPlanetSizeMins() {
		Map<Integer, Integer> sizes = new HashMap<Integer, Integer>();
		sizes.put(1, 40);
		sizes.put(2, 40);
		sizes.put(3, 40);
		sizes.put(4, 120);
		sizes.put(5, 120);
		sizes.put(6, 120);
		sizes.put(7, 105);
		sizes.put(8, 105);
		sizes.put(9, 105);
		sizes.put(10, 75);
		sizes.put(11, 75);
		sizes.put(12, 75);
		sizes.put(13, 60);
		sizes.put(14, 60);
		sizes.put(15, 60);
		return sizes;
	}

	public Map<Integer, Integer> getPlanetSizeMaxs() {
		Map<Integer, Integer> sizes = new HashMap<Integer, Integer>();
		sizes.put(1, 70);
		sizes.put(2, 70);
		sizes.put(3, 70);
		sizes.put(4, 310);
		sizes.put(5, 310);
		sizes.put(6, 310);
		sizes.put(7, 195);
		sizes.put(8, 195);
		sizes.put(9, 195);
		sizes.put(10, 125);
		sizes.put(11, 125);
		sizes.put(12, 125);
		sizes.put(13, 190);
		sizes.put(14, 190);
		sizes.put(15, 190);
		return sizes;
	}
}
