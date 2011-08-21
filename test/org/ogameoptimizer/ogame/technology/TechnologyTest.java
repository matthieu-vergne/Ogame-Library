package org.ogameoptimizer.ogame.technology;

import org.ogameoptimizer.ogame.LeveledElement;
import org.ogameoptimizer.ogame.LeveledElementTest;

public abstract class TechnologyTest extends LeveledElementTest {
	@Override
	public LeveledElement createLeveledElement() {
		return createTechnology();
	}

	abstract public Technology createTechnology();
}
