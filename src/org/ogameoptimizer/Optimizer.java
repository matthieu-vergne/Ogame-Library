package org.ogameoptimizer;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.WindowConstants;

import org.ogameoptimizer.gui.panel.UserPanel;
import org.ogameoptimizer.ogame.Planet;
import org.ogameoptimizer.ogame.User;
import org.ogameoptimizer.ogame.building.resources.CrystalMine;
import org.ogameoptimizer.ogame.building.resources.DeuteriumMine;
import org.ogameoptimizer.ogame.building.resources.MetalMine;
import org.ogameoptimizer.ogame.building.resources.Producer;
import org.ogameoptimizer.ogame.building.resources.SolarCentral;

@SuppressWarnings("serial")
public class Optimizer extends JFrame {
	private User user = new User();

	public static void main(String[] args) {
		new Optimizer().setVisible(true);
	}

	public Optimizer() {
		setTitle("Ogame Optimizer");
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon.png"));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1000, 800));
		
		initMenu();

		initUser();
		getContentPane().setLayout(new GridLayout(1, 1));
		getContentPane().add(new UserPanel(user));

		pack();
		setLocationRelativeTo(null);
	}

	private void initMenu() {
		JMenuBar menubar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		fileMenu.add(new AbstractAction("Save") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				save(user);
			}
		});
		fileMenu.add(new AbstractAction("Load") {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				user = readUser(user.getName());
			}
		});
		menubar.add(fileMenu);
		setJMenuBar(menubar );
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

	public void save(User user) {
		try {
			FileOutputStream fos = new FileOutputStream("user."
					+ user.getName() + ".txt");
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(user);
			out.close();
		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

	public User readUser(String name) {
		User user = null;
		try {
			FileInputStream fis = new FileInputStream("user." + name + ".txt");
			ObjectInputStream in = new ObjectInputStream(fis);
			user = (User) in.readObject();
			in.close();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return user;
	}
}
