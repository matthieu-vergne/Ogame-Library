package com.ogamelib.technology;

import org.junit.Test;

import com.ogamelib.resource.ResourceSet;
import com.ogamelib.technology.IntergalacticSearchNetwork;
import com.ogamelib.technology.Technology;

import static org.junit.Assert.*;

public class IntergalacticSearchNetworkTest extends TechnologyTest {

	@Override
	public Technology createTechnology() {
		return new IntergalacticSearchNetwork();
	}

	@Test
	public void testCostFormula() {
		IntergalacticSearchNetwork technology = new IntergalacticSearchNetwork();

		{
			technology.setLevel(0);
			ResourceSet cost = technology.getNextLevelCost();
			assertEquals(240000, (long) cost.metal.getAmount());
			assertEquals(400000, (long) cost.crystal.getAmount());
			assertEquals(160000, (long) cost.deuterium.getAmount());
			assertEquals(0, (long) cost.antimatter.getAmount());
			assertEquals(0, (long) cost.energy.getAmount());
		}

		// TODO complete with other levels
	}
}
