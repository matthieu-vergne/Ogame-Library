package org.ogameoptimizer.gui.bloc;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

import org.ogameoptimizer.ogame.building.Building;
import org.ogameoptimizer.ogame.building.resources.Producer;

@SuppressWarnings("serial")
public class BuildingTree extends JTree {
	private final MutableTreeNode root;
	private final Collection<Building> buildings = new ArrayList<Building>();

	public BuildingTree(Building... buildings) {
		super(new DefaultMutableTreeNode("Producers"));
		root = (MutableTreeNode) getModel().getRoot();
		for (Building building : buildings) {
			addBuilding(building);
		}
		setRootVisible(false);
	}

	public Building[] getBuildings() {
		return buildings.toArray(new Building[buildings.size()]);
	}

	public void addBuilding(Building building) {
		if (!buildings.contains(building)) {
			buildings.add(building);
			String name = building.getClass().getSimpleName();
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(name);

			if (building instanceof Producer) {
				Producer producer = (Producer) building;
				Integer level = producer.getLevel();
				Long metal = producer.getProductionBaseForMetal();
				Long crystal = producer.getProductionBaseForCrystal();
				Long deuterium = producer.getProductionBaseForDeuterium();
				Long antimatter = producer.getProductionBaseForAntimatter();
				Long energy = producer.getProductionBaseForEnergy();
				Double rate = producer.getActualProductionRate();

				newNode.add(new DefaultMutableTreeNode("Level : " + level));
				if (metal != 0) {
					newNode.add(new DefaultMutableTreeNode(describeProduction(
							"Metal", metal, rate)));
				}
				if (crystal != 0) {
					newNode.add(new DefaultMutableTreeNode(describeProduction(
							"Crystal", crystal, rate)));
				}
				if (deuterium != 0) {
					newNode.add(new DefaultMutableTreeNode(describeProduction(
							"Deuterium", deuterium, rate)));
				}
				if (antimatter != 0) {
					newNode.add(new DefaultMutableTreeNode("Antimatter : "
							+ antimatter));
				}
				if (energy != 0) {
					newNode.add(new DefaultMutableTreeNode(describeProduction(
							"Energy", energy, rate)));
				}
			}

			root.insert(newNode, root.getChildCount());
			setModel(new DefaultTreeModel(root));
		}
	}

	private String describeProduction(String name, Long valueMax, Double rate) {
		if (rate == 1) {
			return name + " : " + valueMax;
		} else {
			return name + " : " + (long) Math.floor(valueMax * rate) + "/"
					+ valueMax + " (" + (int) (rate * 100) + ")%";
		}
	}
}
