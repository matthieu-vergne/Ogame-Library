package org.ogameoptimizer;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.ogameoptimizer.gui.bloc.UserPanel;
import org.ogameoptimizer.ogame.Planet;
import org.ogameoptimizer.ogame.User;
import org.ogameoptimizer.ogame.building.resources.CrystalMine;
import org.ogameoptimizer.ogame.building.resources.DeuteriumMine;
import org.ogameoptimizer.ogame.building.resources.MetalMine;
import org.ogameoptimizer.ogame.building.resources.Producer;
import org.ogameoptimizer.ogame.building.resources.SolarCentral;

@SuppressWarnings("serial")
public class Optimizer extends JFrame {
	private final User user = new User();

	public static void main(String[] args) {
		new Optimizer().setVisible(true);
	}

	public Optimizer() {
		setTitle("Ogame Optimizer");
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1000, 800));

		initUser();
		getContentPane().setLayout(new GridLayout(1, 1));
		getContentPane().add(new UserPanel(user));

		pack();
		setLocationRelativeTo(null);
	}

	private void initUser() {
		user.setName("test-user");

		Planet planet = new Planet();
		planet.getMetal().setActualAmount(10L);
		planet.getCrystal().setActualAmount(20L);
		planet.getDeuterium().setActualAmount(30L);
		planet.getEnergy().setActualAmount(10L);

		Producer producer = new MetalMine();
		producer.setPlanet(planet);
		producer.setLevel(4);
		planet.addBuilding(producer);

		producer = new CrystalMine();
		producer.setPlanet(planet);
		producer.setLevel(2);
		planet.addBuilding(producer);

		producer = new DeuteriumMine();
		producer.setPlanet(planet);
		producer.setLevel(2);
		producer.setMaximumProductionRate(0.6);
		planet.addBuilding(producer);

		producer = new SolarCentral();
		producer.setPlanet(planet);
		producer.setLevel(4);
		planet.addBuilding(producer);

		planet.setName("test-planet");

		user.acquirePlanet(planet);
	}
}
