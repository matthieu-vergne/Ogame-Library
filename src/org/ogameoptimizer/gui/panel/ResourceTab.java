package org.ogameoptimizer.gui.panel;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.ogameoptimizer.gui.tree.BuildingTree;
import org.ogameoptimizer.ogame.Planet;
import org.ogameoptimizer.ogame.building.Building;
import org.ogameoptimizer.ogame.resource.IProducer;

@SuppressWarnings("serial")
public class ResourceTab extends JPanel {

	public ResourceTab(Planet planet) {
		setLayout(new GridLayout(1, 2));
		
		BuildingTree tree = new BuildingTree();
		for (IProducer producer : planet.getProducers(true)) {
			tree.addBuilding((Building) producer);
		}
		add(tree);
		
		add(new JLabel("array"));
	}
}
