package org.ogameoptimizer.gui.tree;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;

import org.ogameoptimizer.ogame.building.Building;

@SuppressWarnings("serial")
public class BuildingTree extends JTree {
	private final MutableTreeNode root;

	public BuildingTree(Building... buildings) {
		super(new DefaultMutableTreeNode("Producers"));
		root = (MutableTreeNode) getModel().getRoot();
		for (Building building : buildings) {
			addBuilding(building);
		}
		setRootVisible(false);
	}

	public void addBuilding(Building building) {
		root.insert(new BuildingNode(building), root.getChildCount());
		setModel(new DefaultTreeModel(root));
	}

}
