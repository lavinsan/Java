package java_seven;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class to convert map to list and then sorting both ways
 * 
 * @author Vinod
 *
 */
public class ListExpMap2List {

	static Map<Integer, String> unsortMap = new LinkedHashMap<>();

	public static void main(String[] args) {
		// To insert data in the map
		createMap();

		// Map to Key List 
		// map --- entrySet --- stream --- map --- collect --- forEach
		List<Integer> listKey1 = unsortMap.entrySet().stream().map(x -> x.getKey()).collect(Collectors.toList());
		
		// Lot of ways of sorting 
		// listKey1.sort((a, b) -> a.compareTo(b));
		// listKey1.sort(Integer::compareTo);
		listKey1.sort(Comparator.naturalOrder());
		listKey1.forEach(x -> System.out.println("Key : " + x));

		// Lot of ways of reverse sorting
		List<Integer> listKey2 = unsortMap.entrySet().stream().map(x -> x.getKey()).collect(Collectors.toList());
		//listKey2.sort((a, b) -> b.compareTo(a));
		listKey2.sort(Comparator.reverseOrder());
		listKey2.forEach(x -> System.out.println("Key : " + x));

		List<String> listValue1 = unsortMap.entrySet().stream().map(x -> x.getValue()).sorted()
				.collect(Collectors.toList());
		listValue1.forEach(x -> System.out.println("Value : " + x));
		
	}

	/**
	 * Static Method to insert values in map
	 */
	public static void createMap() {
		unsortMap.put(10, "z");
		unsortMap.put(5, "b");
		unsortMap.put(20, "c");
		unsortMap.put(1, "d");
		unsortMap.put(99, "n");
		unsortMap.put(50, "j");
		unsortMap.put(2, "m");
		unsortMap.put(9, "f");
	}

}
