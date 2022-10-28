package com.epam.stub;

public class HouseBuilder {
	
	public void buildHouse(HouseArchitect architecture) {
		String kitchenDesign = architecture.kitchenDesign();
		String roomDesgin = architecture.roomDesign();
		System.out.println("Built - "+kitchenDesign+" and "+roomDesgin);
	}
	
	public int getArchitectureCost(HouseArchitect architecture) {
		int totalCost = 0;
		totalCost = totalCost + architecture.kitchenCost();
		totalCost = totalCost + architecture.roomCost();
		return totalCost;
	}
	
}
