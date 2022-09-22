package Oops1;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {

		ArrayList<Flower> flowers = new ArrayList<>();
		Flower f = new Rose("Pink Rose", 100);
		flowers.add(f);
		f = new Lotus("White Lotus", 200);
		flowers.add(f);
		
		int totalCost = 0;
		
		for(Flower item : flowers) {
			totalCost += item.getCost();
		}

		System.out.println(totalCost);
	}

}
