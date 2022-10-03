package exercise2;

import java.util.List;

// Print all the values having length greater than or equal 5 or there name start with s.

public class StreamFilter2 {

	public static void main(String[] args) {
		List<String> list = List.of("Sourabh", "Amit", "Sumit", "Yogesh", "Rahul", "Sonu", "Ravi");
		list.stream().filter(StreamFilter2::validString).forEach(System.out::println);
	}
	
	public static boolean validString(String str) {
		if(str.length()>= 5) {
			return true;
		}
		else if(str.toLowerCase().startsWith("s")) {
			return true;
		}
		return false;
	}

}
