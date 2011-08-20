package org.ogameoptimizer.gui.panel;

import javax.swing.JTabbedPane;

import org.ogameoptimizer.ogame.Planet;
import org.ogameoptimizer.ogame.User;

@SuppressWarnings("serial")
public class UserPanel extends JTabbedPane {
	public UserPanel(User user) {
		for (Planet planet : user.getPlanets()) {
			addTab(planet.getName(), new PlanetTab(planet));
		}
	}
}
