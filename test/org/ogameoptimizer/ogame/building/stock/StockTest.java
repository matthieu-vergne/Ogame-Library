package org.ogameoptimizer.ogame.building.stock;

import org.ogameoptimizer.ogame.building.Building;
import org.ogameoptimizer.ogame.building.BuildingTest;

public abstract class StockTest extends BuildingTest {

	@Override
	public Building createBuilding() {
		return createStock();
	}

	abstract public Stock createStock();
}
