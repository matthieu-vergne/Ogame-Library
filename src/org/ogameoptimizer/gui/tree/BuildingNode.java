package org.ogameoptimizer.gui.tree;

import javax.swing.tree.DefaultMutableTreeNode;

import org.ogameoptimizer.ogame.building.Building;
import org.ogameoptimizer.ogame.building.resources.Producer;

@SuppressWarnings("serial")
public class BuildingNode extends DefaultMutableTreeNode {

	private final Building building;

	public BuildingNode(Building building) {
		super(building.getClass().getSimpleName());
		this.building = building;

		if (building instanceof Producer) {
			initProductionNodes((Producer) building);
		}
	}

	private void initProductionNodes(Producer producer) {
		Integer level = producer.getLevel();
		Long metal = producer.getProductionBaseForMetal();
		Long crystal = producer.getProductionBaseForCrystal();
		Long deuterium = producer.getProductionBaseForDeuterium();
		Long antimatter = producer.getProductionBaseForAntimatter();
		Long energy = producer.getProductionBaseForEnergy();
		Double rate = producer.getActualProductionRate();

		add(new DefaultMutableTreeNode("Level : " + level));
		if (metal != 0) {
			add(new ProductionNode("Metal", metal, rate));
		}
		if (crystal != 0) {
			add(new ProductionNode("Crystal", crystal, rate));
		}
		if (deuterium != 0) {
			add(new ProductionNode("Deuterium", deuterium, rate));
		}
		if (antimatter != 0) {
			add(new ProductionNode("Antimatter : ", antimatter, 1.0));
		}
		if (energy != 0) {
			add(new ProductionNode("Energy", energy, rate));
		}
	}

	public Building getBuilding() {
		return building;
	}
}
