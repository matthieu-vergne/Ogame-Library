package org.ogameoptimizer.gui.panel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.ogameoptimizer.ogame.resource.Resource;

@SuppressWarnings("serial")
public class ResourceComponent extends JPanel {
	private final JLabel name;
	private final JTextField value;

	public ResourceComponent(final Resource resource) {
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);

		{
			name = new JLabel();
			name.setText(resource.getClass().getSimpleName());
			GridBagConstraints constraint = new GridBagConstraints();
			constraint.gridx = 0;
			constraint.gridy = 0;
			constraint.fill = GridBagConstraints.NONE;
			add(name, constraint);
		}

		{
			value = new JFormattedTextField(resource.getActualAmount());
			value.setMinimumSize(new Dimension(100, 5));
			value.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					long newAmount = Long.parseLong(((JTextField) e.getSource())
							.getText());
					resource.setActualAmount(newAmount);
				}
			});
			value.setPreferredSize(new Dimension(50, value.getPreferredSize().height));
			GridBagConstraints constraint = new GridBagConstraints();
			constraint.gridx = 1;
			constraint.gridy = 0;
			constraint.fill = GridBagConstraints.HORIZONTAL;
			constraint.weightx = 1;
			constraint.insets = new Insets(0, 5, 0, 0);
			add(value, constraint);
		}
	}
}
