package org.ogameoptimizer.gui.panel;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import org.ogameoptimizer.ogame.Planet;
import org.ogameoptimizer.ogame.resource.Resource;

@SuppressWarnings("serial")
public class ResourceMultiComponent extends JPanel {

	public ResourceMultiComponent(Planet planet) {
		setLayout(new FlowLayout());

		for (final Resource resource : new Resource[] { planet.getMetal(),
				planet.getCrystal(), planet.getDeuterium(),
				planet.getAntimatter(), planet.getEnergy() }) {
			add(new ResourceComponent(resource));
		}

	}
}
