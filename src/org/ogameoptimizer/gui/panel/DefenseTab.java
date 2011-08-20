package org.ogameoptimizer.gui.panel;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.ogameoptimizer.ogame.Planet;

@SuppressWarnings("serial")
public class DefenseTab extends JPanel {

	public DefenseTab(Planet planet) {
		setLayout(new FlowLayout());
		add(new JLabel("Defense"));
	}
}
