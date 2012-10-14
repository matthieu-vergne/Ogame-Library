package com.ogamelib.technology;


import com.ogamelib.LeveledElement;
import com.ogamelib.LeveledElementTest;
import com.ogamelib.technology.Technology;

public abstract class TechnologyTest extends LeveledElementTest {
	@Override
	public LeveledElement createLeveledElement() {
		return createTechnology();
	}

	abstract public Technology createTechnology();
}
