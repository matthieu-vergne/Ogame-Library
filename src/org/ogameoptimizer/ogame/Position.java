package org.ogameoptimizer.ogame;

public class Position {

	private final Integer galaxy;
	private final Integer system;
	private final Integer rank;

	public Position(Integer galaxy, Integer system, Integer rank) {
		this.galaxy = galaxy;
		this.system = system;
		this.rank = rank;
	}

	public Integer getGalaxy() {
		return galaxy;
	}

	public Integer getSystem() {
		return system;
	}

	public Integer getRank() {
		return rank;
	}
	
	@Override
	public String toString() {
		return "["+getGalaxy()+":"+getSystem()+":"+getRank()+"]";
	}
}
