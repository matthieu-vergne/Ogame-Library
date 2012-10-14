package com.ogamelib;

import java.util.Random;

// TODO check all classes to extract data and functions
public class OgameData {
	private final String universe;

	public OgameData(String universe) {
		this.universe = universe;
	}

	public int getGalaxyAmount() {
		return 9;
	}

	public int getSystemAmount() {
		return 499;
	}

	public int getRankAmount() {
		return 15;
	}

	public String getUniverse() {
		return universe;
	}

	public int getMaxTemperaturesAverage(int rank) {
		if (universe.equals("65")) {
			if (rank >= 1 && rank <= 3) {
				return 122;
			} else if (rank >= 4 && rank <= 6) {
				return 65;
			} else if (rank >= 7 && rank <= 9) {
				return 35;
			} else if (rank >= 10 && rank <= 12) {
				return 15;
			} else if (rank >= 13 && rank <= 15) {
				return -40;
			} else {
				throw new IllegalArgumentException("No data for the rank "
						+ rank);
			}
		} else {
			throw new IllegalStateException("No data for the universe "
					+ universe);
		}
	}

	public int getPlanetSizeMin(int rank) {
		if (universe.equals("65")) {
			if (rank >= 1 && rank <= 3) {
				return 40;
			} else if (rank >= 4 && rank <= 6) {
				return 120;
			} else if (rank >= 7 && rank <= 9) {
				return 105;
			} else if (rank >= 10 && rank <= 12) {
				return 75;
			} else if (rank >= 13 && rank <= 15) {
				return 60;
			} else {
				throw new IllegalArgumentException("No data for the rank "
						+ rank);
			}
		} else {
			throw new IllegalStateException("No data for the universe "
					+ universe);
		}
	}

	public int getPlanetSizeMax(int rank) {
		if (universe.equals("65")) {
			if (rank >= 1 && rank <= 3) {
				return 70;
			} else if (rank >= 4 && rank <= 6) {
				return 310;
			} else if (rank >= 7 && rank <= 9) {
				return 195;
			} else if (rank >= 10 && rank <= 12) {
				return 125;
			} else if (rank >= 13 && rank <= 15) {
				return 190;
			} else {
				throw new IllegalArgumentException("No data for the rank "
						+ rank);
			}
		} else {
			throw new IllegalStateException("No data for the universe "
					+ universe);
		}
	}

	public PlanetSizeComputer getPlanetSizeComputer() {
		if (universe.equals("65")) {
			return new PlanetSizeComputer() {
				private final Random rand = new Random();

				@Override
				public int compute(int rank) {
					double min = getPlanetSizeMin(rank);
					double max = getPlanetSizeMax(rank);

					// FIXME should not be linear
					double a = (max - min) / 0.8;
					double b = min - a * 0.1;
					double x = rand.nextDouble();
					int size = (int) Math.floor(a * x + b);
					return size;
				}
			};
		} else {
			throw new IllegalStateException("No data for the universe "
					+ universe);
		}
	}

	public static interface PlanetSizeComputer {
		public int compute(int rank);
	}

	/**
	 * 
	 * @param rank
	 * @return An array of temperatures (minimum, average)
	 */
	public TemperatureComputer getTemperatureComputer() {
		if (universe.equals("65")) {
			return new TemperatureComputer() {
				private final Random rand = new Random();

				@Override
				public int[] compute(int rank) {
					// FIXME test with reliable data
					int maxAverage = getMaxTemperaturesAverage(rank);
					int minAverage = maxAverage - 70;
					int maxTemp = maxAverage + rand.nextInt(20) - 10;
					int minTemp = minAverage + rand.nextInt(20) - 10;
					int[] temperature = new int[] { minTemp,
							(minTemp + maxTemp) / 2 };
					return temperature;
				}
			};
		} else {
			throw new IllegalStateException("No data for the universe "
					+ universe);
		}
	}

	public static interface TemperatureComputer {
		public int[] compute(int rank);
	}
}
