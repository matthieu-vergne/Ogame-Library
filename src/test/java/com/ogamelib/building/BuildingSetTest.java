package com.ogamelib.building;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

import com.ogamelib.Introspection;
import com.ogamelib.building.Building;
import com.ogamelib.building.BuildingSet;

public class BuildingSetTest {

	@Test
	public void testContainsAllBuildings() throws ClassNotFoundException,
			IOException {
		BuildingSet set = new BuildingSet();

		// get the possible building implementations
		List<Class<?>> classes = Introspection
				.getClasses("org.ogameoptimizer.ogame.building");

		// remove the tests, abstract/interface classes and the BuildingSet
		// itself
		for (Class<?> clazz : classes.toArray(new Class[classes.size()])) {
			if (clazz.getSimpleName().endsWith("Test")
					|| Modifier.isAbstract(clazz.getModifiers())
					|| Modifier.isInterface(clazz.getModifiers())
					|| clazz.equals(BuildingSet.class)) {
				classes.remove(clazz);
			}
		}

		// the test
		for (Class<?> clazz : classes) {
			boolean isPresent = false;
			for (Building building : set) {
				if (building.getClass().equals(clazz)) {
					isPresent = true;
					break;
				}
			}
			if (!isPresent) {
				fail(clazz.getSimpleName() + " is not retrieved in the set.");
			}
		}
	}
}
