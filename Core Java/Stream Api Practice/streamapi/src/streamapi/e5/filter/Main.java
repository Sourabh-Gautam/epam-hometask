package streamapi.e5.filter;

import java.util.List;

// Find the products which has price more than 100.

public class Main {
	public static void main(String[] args) {

		List<Product> list = List.of(
				new Product(1, "Tide", 149),
				new Product(2, "Surf Excel", 199),
				new Product(3, "Nirma", 99));
		List<Product> list2 = list.stream().filter(e -> e.getProductPrice()>100).toList();
		System.out.println(list2);
	}
}
