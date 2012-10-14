package com.ogamelib;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import com.ogamelib.resource.Resource;
import com.ogamelib.resource.ResourceSet;

public abstract class LeveledElement implements Externalizable {
	private Integer level = 0;

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(level);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		level = in.readInt();
	}

	abstract public ResourceSet getInitialCost();

	public ResourceSet getNextLevelCost() {
		ResourceSet cost = getInitialCost();
		for (Resource resource : new Resource[] { cost.metal, cost.crystal,
				cost.deuterium, cost.antimatter, cost.energy }) {
			resource.setAmount((long) (resource.getAmount() * Math.pow(2,
					getLevel())));
		}
		return cost;
	}
}
