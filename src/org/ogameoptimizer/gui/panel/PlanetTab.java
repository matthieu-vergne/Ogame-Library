package org.ogameoptimizer.gui.panel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.ogameoptimizer.ogame.Planet;

@SuppressWarnings("serial")
public class PlanetTab extends JPanel {
	public PlanetTab(Planet planet) {
		setLayout(new GridBagLayout());

		{
			GridBagConstraints constraint = new GridBagConstraints();
			constraint.gridx = 0;
			constraint.gridy = 0;
			add(new ResourceMultiComponent(planet), constraint);
		}

		{
			JTabbedPane domainTabs = new JTabbedPane();
			domainTabs.addTab("Resources", new ResourceTab(planet));
			domainTabs.addTab("Defense", new DefenseTab(planet));
			GridBagConstraints constraint = new GridBagConstraints();
			constraint.gridx = 0;
			constraint.gridy = 1;
			constraint.fill = GridBagConstraints.BOTH;
			constraint.weightx = 1;
			constraint.weighty = 1;
			add(domainTabs, constraint);
		}
	}
}
