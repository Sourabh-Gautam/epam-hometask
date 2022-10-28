package com.epam.test.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.epam.stub.HouseArchitect;
import com.epam.stub.HouseBuilder;

public class HouseBuilderTest {
	
	@Test
	void costTest(){
		HouseArchitect architect = mock(HouseArchitect.class);
		when(architect.roomCost()).thenReturn(2000);
		when(architect.kitchenCost()).thenReturn(3000);
		HouseBuilder builder = new HouseBuilder();
		int cost = builder.getArchitectureCost(architect);
		assertEquals(5000, cost);
	}
	
}
