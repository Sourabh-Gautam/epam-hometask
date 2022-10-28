package com.epam.test.stub;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.epam.stub.HouseBuilder;
import com.epam.stub.StubArchitect;

public class HouseBuilderTest {

	@Test
	void costTest(){
		StubArchitect architect = new StubArchitect();
		HouseBuilder builder = new HouseBuilder();
		int cost = builder.getArchitectureCost(architect);
		assertEquals(5000, cost);
	}
	
}
