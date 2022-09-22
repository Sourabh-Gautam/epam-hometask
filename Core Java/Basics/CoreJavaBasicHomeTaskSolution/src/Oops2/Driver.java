package Oops2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Driver {

	public static void main(String[] args) {

		List<Sweet> sweet = new ArrayList<>();
		sweet.add(new Raspberry(new Gift(10)));
		sweet.add(new Chocolate(new Gift(20)));
		sweet.add(new Barfi(new Gift(15)));
		
		Collections.sort(sweet);
		
		System.out.println(sweet);
		
	}

}
