package org.ogameoptimizer.ogame.building.tank;

import org.ogameoptimizer.ogame.building.Building;
import org.ogameoptimizer.ogame.building.BuildingTest;
import org.ogameoptimizer.ogame.building.tank.Tank;

public abstract class TankTest extends BuildingTest {

	@Override
	public Building createBuilding() {
		return createStock();
	}

	abstract public Tank createStock();
}
