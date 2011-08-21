package org.ogameoptimizer.ogame.technology;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;
import org.ogameoptimizer.util.Introspection;

public class TechnologySetTest {

	@Test
	public void testContainsAllBuildings() throws ClassNotFoundException,
			IOException {
		TechnologySet set = new TechnologySet();

		// get the possible building implementations
		List<Class<?>> classes = Introspection
				.getClasses("org.ogameoptimizer.ogame.technology");

		// remove the tests, abstract/interface classes and the BuildingSet
		// itself
		for (Class<?> clazz : classes.toArray(new Class[classes.size()])) {
			if (clazz.getSimpleName().endsWith("Test")
					|| Modifier.isAbstract(clazz.getModifiers())
					|| Modifier.isInterface(clazz.getModifiers())
					|| clazz.equals(TechnologySet.class)) {
				classes.remove(clazz);
			}
		}

		// the test
		for (Class<?> clazz : classes) {
			boolean isPresent = false;
			for (Technology building : set) {
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
