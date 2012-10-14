package com.ogamelib.building.tank;


import com.ogamelib.building.Building;
import com.ogamelib.building.BuildingTest;
import com.ogamelib.building.tank.Tank;

public abstract class TankTest extends BuildingTest {

	@Override
	public Building createBuilding() {
		return createStock();
	}

	abstract public Tank createStock();
}
