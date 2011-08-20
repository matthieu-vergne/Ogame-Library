package org.ogameoptimizer.gui.tree;

import javax.swing.tree.DefaultMutableTreeNode;

@SuppressWarnings("serial")
public class ProductionNode extends DefaultMutableTreeNode {

	public ProductionNode(String name, Long valueMax, Double rate) {
		super((rate == 1) ? name + " : " + valueMax : name + " : "
				+ (long) Math.floor(valueMax * rate) + "/" + valueMax + " ("
				+ (int) (rate * 100) + ")%");
	}
}
