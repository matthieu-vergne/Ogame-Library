package com.ogamelib;

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

}
