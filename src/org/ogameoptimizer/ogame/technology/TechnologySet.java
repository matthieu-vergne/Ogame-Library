package org.ogameoptimizer.ogame.technology;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class TechnologySet implements Iterable<Technology>, Externalizable {
	public final Astrophysics astrophysics = new Astrophysics();
	public final CombustionReactor combustionReactor = new CombustionReactor();
	public final Computer computer = new Computer();
	public final Energy energy = new Energy();
	public final Graviton graviton = new Graviton();
	public final Hyperspace hyperspace = new Hyperspace();
	public final HyperspacePropulsion hyperspacePropulsion = new HyperspacePropulsion();
	public final ImpulsionReactor impulsionReactor = new ImpulsionReactor();
	public final IntergalacticSearchNetwork intergalacticSearchNetwork = new IntergalacticSearchNetwork();
	public final Ions ions = new Ions();
	public final Lazer lazer = new Lazer();
	public final Plasma plasma = new Plasma();
	public final Shield shield = new Shield();
	public final SpaceshipProtection spaceshipProtection = new SpaceshipProtection();
	public final Spy spy = new Spy();
	public final Weapon weapon = new Weapon();

	public Technology[] toBuildingArray() {
		Collection<Technology> buildings = new ArrayList<Technology>();
		for (Technology building : this) {
			buildings.add(building);
		}
		return buildings.toArray(new Technology[buildings.size()]);
	}

	@Override
	public Iterator<Technology> iterator() {
		return new TechnologyIterator(this);
	}

	private class TechnologyIterator implements Iterator<Technology> {
		private final List<Field> fields;
		private final TechnologySet set;

		public TechnologyIterator(TechnologySet set) {
			try {
				Class<?> clazz = Class.forName(TechnologySet.class.getName());
				fields = new ArrayList<Field>(Arrays.asList(clazz.getFields()));
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
			this.set = set;
		}

		@Override
		public boolean hasNext() {
			return !fields.isEmpty();
		}

		@Override
		public Technology next() {
			try {
				return (Technology) fields.remove(0).get(set);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		@Override
		public void remove() {
			throw new IllegalStateException(
					"The buildings cannot be removed from this set.");
		}

	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(astrophysics.getLevel());
		out.writeInt(combustionReactor.getLevel());
		out.writeInt(computer.getLevel());
		out.writeInt(energy.getLevel());
		out.writeInt(graviton.getLevel());
		out.writeInt(hyperspace.getLevel());
		out.writeInt(hyperspacePropulsion.getLevel());
		out.writeInt(impulsionReactor.getLevel());
		out.writeInt(intergalacticSearchNetwork.getLevel());
		out.writeInt(ions.getLevel());
		out.writeInt(lazer.getLevel());
		out.writeInt(plasma.getLevel());
		out.writeInt(shield.getLevel());
		out.writeInt(spaceshipProtection.getLevel());
		out.writeInt(spy.getLevel());
		out.writeInt(weapon.getLevel());
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		astrophysics.setLevel(in.readInt());
		combustionReactor.setLevel(in.readInt());
		computer.setLevel(in.readInt());
		energy.setLevel(in.readInt());
		graviton.setLevel(in.readInt());
		hyperspace.setLevel(in.readInt());
		hyperspacePropulsion.setLevel(in.readInt());
		impulsionReactor.setLevel(in.readInt());
		intergalacticSearchNetwork.setLevel(in.readInt());
		ions.setLevel(in.readInt());
		lazer.setLevel(in.readInt());
		plasma.setLevel(in.readInt());
		shield.setLevel(in.readInt());
		spaceshipProtection.setLevel(in.readInt());
		spy.setLevel(in.readInt());
		weapon.setLevel(in.readInt());
	}
}
