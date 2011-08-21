package org.ogameoptimizer.ogame.building;

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

import org.ogameoptimizer.ogame.Planet;
import org.ogameoptimizer.ogame.building.producer.CrystalMine;
import org.ogameoptimizer.ogame.building.producer.DeuteriumMine;
import org.ogameoptimizer.ogame.building.producer.FusionCentral;
import org.ogameoptimizer.ogame.building.producer.MetalMine;
import org.ogameoptimizer.ogame.building.producer.SolarCentral;
import org.ogameoptimizer.ogame.building.stock.CrystalStock;
import org.ogameoptimizer.ogame.building.stock.DeuteriumStock;
import org.ogameoptimizer.ogame.building.stock.MetalStock;

public class BuildingSet implements Iterable<Building>, Externalizable {
	public final SolarCentral solarCentral = new SolarCentral();
	public final MetalMine metalMine = new MetalMine();
	public final CrystalMine crystalMine = new CrystalMine();
	public final DeuteriumMine deuteriumMine = new DeuteriumMine();
	public final FusionCentral fusionCentral = new FusionCentral();
	public final MetalStock metalStock = new MetalStock();
	public final CrystalStock crystalStock = new CrystalStock();
	public final DeuteriumStock deuteriumStock = new DeuteriumStock();

	public Building[] toBuildingArray() {
		Collection<Building> buildings = new ArrayList<Building>();
		for (Building building : this) {
			buildings.add(building);
		}
		return buildings.toArray(new Building[buildings.size()]);
	}

	public void setPlanet(Planet planet) {
		for (Building building : this) {
			building.setPlanet(planet);
		}
	}

	public Planet getPlanet() {
		return solarCentral.getPlanet();
	}

	@Override
	public Iterator<Building> iterator() {
		return new BuildingIterator(this);
	}

	private class BuildingIterator implements Iterator<Building> {
		private final List<Field> fields;
		private final BuildingSet set;

		public BuildingIterator(BuildingSet set) {
			try {
				Class<?> clazz = Class.forName(BuildingSet.class.getName());
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
		public Building next() {
			try {
				return (Building) fields.remove(0).get(set);
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
		out.writeInt(solarCentral.getLevel());
		out.writeDouble(solarCentral.getMaximumProductionRate());

		out.writeInt(metalMine.getLevel());
		out.writeDouble(metalMine.getMaximumProductionRate());

		out.writeInt(crystalMine.getLevel());
		out.writeDouble(crystalMine.getMaximumProductionRate());

		out.writeInt(deuteriumMine.getLevel());
		out.writeDouble(deuteriumMine.getMaximumProductionRate());

		out.writeInt(fusionCentral.getLevel());
		out.writeDouble(fusionCentral.getMaximumProductionRate());

		out.writeInt(metalStock.getLevel());
		out.writeInt(crystalStock.getLevel());
		out.writeInt(deuteriumStock.getLevel());

		out.writeObject(getPlanet());
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		solarCentral.setLevel(in.readInt());
		solarCentral.setMaximumProductionRate(in.readDouble());

		metalMine.setLevel(in.readInt());
		metalMine.setMaximumProductionRate(in.readDouble());

		crystalMine.setLevel(in.readInt());
		crystalMine.setMaximumProductionRate(in.readDouble());

		deuteriumMine.setLevel(in.readInt());
		deuteriumMine.setMaximumProductionRate(in.readDouble());

		fusionCentral.setLevel(in.readInt());
		fusionCentral.setMaximumProductionRate(in.readDouble());

		metalStock.setLevel(in.readInt());
		crystalStock.setLevel(in.readInt());
		deuteriumStock.setLevel(in.readInt());

		setPlanet((Planet) in.readObject());
	}
}
