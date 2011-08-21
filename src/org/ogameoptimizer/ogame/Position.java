package org.ogameoptimizer.ogame;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Position implements Externalizable {

	private static final long serialVersionUID = 1L;

	/**
	 * Give an example position [4:358:12].
	 */
	public Position() {
		this(4, 358, 12);
	}

	public Position(Integer galaxy, Integer system, Integer rank) {
		this.galaxy = galaxy;
		this.system = system;
		this.rank = rank;
	}

	private Integer galaxy;

	public Integer getGalaxy() {
		return galaxy;
	}

	private Integer system;

	public Integer getSystem() {
		return system;
	}

	private Integer rank;

	public Integer getRank() {
		return rank;
	}

	@Override
	public String toString() {
		return "[" + getGalaxy() + ":" + getSystem() + ":" + getRank() + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Position) {
			return toString().equals(((Position) obj).toString());
		}
		return false;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(galaxy);
		out.writeInt(system);
		out.writeInt(rank);
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		galaxy = in.readInt();
		system = in.readInt();
		rank = in.readInt();
	}
}
