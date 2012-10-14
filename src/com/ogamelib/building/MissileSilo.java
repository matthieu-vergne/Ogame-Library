package com.ogamelib.building;

import com.ogamelib.resource.ResourceSet;

public class MissileSilo extends Building {

	@Override
	public ResourceSet getInitialCost() {
		return new ResourceSet(20000L, 20000L, 1000L);
	}

	public Integer getCapacity() {
		return 10 * getLevel();
	}

	public Integer getFreeSpace() {
		return getCapacity() - 2 * InterplanetaryMissileCount
				- InterceptionMissileCount;
	}

	private Integer InterplanetaryMissileCount = 0;

	public Integer getInterplanetaryMissileCount() {
		return InterplanetaryMissileCount;
	}

	public void setInterplanetaryMissileCount(Integer number) {
		InterplanetaryMissileCount = number;
	}

	private Integer InterceptionMissileCount = 0;

	public Integer getInterceptionMissileCount() {
		return InterceptionMissileCount;
	}

	public void setInterceptionMissileCount(Integer number) {
		InterceptionMissileCount = number;
	}
}
