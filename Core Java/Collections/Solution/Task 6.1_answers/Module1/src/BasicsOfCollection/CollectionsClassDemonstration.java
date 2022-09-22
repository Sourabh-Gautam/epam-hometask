package BasicsOfCollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionsClassDemonstration {

	public static void main(String[] args) {
		
		ArrayList<String> name = new ArrayList<>();
		name.add("Sourabh");
		name.add("Gaurav");
		name.add("Rahul");
		
		System.out.println(name);
		System.out.println(name.get(2));
		
		LinkedList<String> deletename = new LinkedList<>();
		deletename.add("Sourabh");
		deletename.add("Gaurav");
		deletename.add("Rahul");
		
		System.out.println(deletename);
		System.out.println(deletename.remove("Sourabh"));
		
		HashMap<String, Integer> areaCode = new HashMap<>();
		areaCode.put("Ghaziabad", 201007);
		areaCode.put("Sahibabad", 201005);
		areaCode.put("Rajendra Nagar", 201003);
		
		System.out.println(areaCode);
		System.out.println(areaCode.get("Ghaziabad"));
		
		LinkedHashMap<String, Integer> 	areaCode2 = new LinkedHashMap<>();
		areaCode2.put("Ghaziabad", 201007);
		areaCode2.put("Sahibabad", 201005);
		areaCode2.put("Rajendra Nagar", 201003);
		System.out.println(areaCode2);
		
		TreeMap<String, Integer> 	areaCode3 = new TreeMap<>();
		areaCode3.put("Ghaziabad", 201007);
		areaCode3.put("Sahibabad", 201005);
		areaCode3.put("Rajendra Nagar", 201003);
		System.out.println(areaCode3);
		
		//insertion order not preserve
		HashSet<Integer> id = new HashSet<>();
		id.add(102);
		id.add(102);
		id.add(101);
		id.add(103);
		System.out.println(id);
		
		//insertion order preserve
		LinkedHashSet<Integer> id2 = new LinkedHashSet<>();
		id2.add(103);
		id2.add(101);
		id2.add(102);
		id2.add(102);
		System.out.println(id2);
		
		//Sorted set
		TreeSet<Integer> id3 = new TreeSet<>();
		id3.add(103);
		id3.add(101);
		id3.add(102);
		id3.add(102);
		System.out.println(id3);

	}

}
