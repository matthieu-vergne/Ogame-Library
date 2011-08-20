package org.ogameoptimizer.gui.bloc;

import java.awt.FlowLayout;

import javax.swing.JPanel;

import org.ogameoptimizer.ogame.Planet;
import org.ogameoptimizer.ogame.resource.Resource;

@SuppressWarnings("serial")
public class AllResourceDisplay extends JPanel {

	public AllResourceDisplay(Planet planet) {
		setLayout(new FlowLayout());

		for (final Resource resource : new Resource[] { planet.getMetal(),
				planet.getCrystal(), planet.getDeuterium(),
				planet.getAntimatter(), planet.getEnergy() }) {
			add(new ResourceDisplay(resource));
		}

	}
}
