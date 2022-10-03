package exercise1;

import java.util.List;
import java.util.function.Consumer;

public class StreamWithList {

	public static void main(String[] args) {
		
		List<Integer> li = List.of(10,20,30,40,50);
		
		System.out.println("Way 1 : Printing stream Using Annonymous Class");
		
		Consumer<Integer> consumer = new Consumer<>() {

			@Override
			public void accept(Integer t) {
				System.out.print(t+" ");
			}
				
		};
		
		li.stream().forEach(consumer);
		
		System.out.println("\n\nWay 2 : Printing stream Using Lambda Expression");
		
		Consumer<Integer> consumerL = t -> System.out.print(t+" ");
		
		li.stream().forEach(consumerL);
		
		System.out.println("\n\nWay 3 : Printing stream Using Method Reference");
		
		li.stream().forEach(StreamWithList::printInteger);
		
	}
	
	public static void printInteger(Integer n) {
		System.out.print(n+" ");
	}

}
