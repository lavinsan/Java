package java_seven;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Class To check all type of map using java 8 and Stream api
 * 
 * @author Vinod
 *
 */
public class MapExpWithJava8 {

	static Map<Integer, String> unsortMap = new LinkedHashMap<>();
	static final String A = "ascending";
	static final String D = "descending";

	public static void main(String[] args) {

		// To insert data in the map
		createMap();

		// Printing the Map in Sorted order Via Key -Ascending order
		System.out.println("\nMap Using LinkedHashMap....... Sorted in Ascending");
		unsortMap = compareByKey(unsortMap, A);
		printMap(unsortMap);

		// Printing the Map in Sorted order Via Key -Descending order
		System.out.println("\nMap Using LinkedHashMap....... Sorted in Descending");
		unsortMap = compareByKey(unsortMap, D);
		printMap(unsortMap);

		// Printing the Map in Sorted order Via Key -Ascending order
		System.out.println("\nMap Using LinkedHashMap....... Sorted in Ascending");
		unsortMap = compareByValue(unsortMap, A);
		printMap(unsortMap);

		// Printing the Map in Sorted order Via Key -Descending order
		System.out.println("\nMap Using LinkedHashMap....... Sorted in Descending");
		unsortMap = compareByValue(unsortMap, D);
		printMap(unsortMap);
	}

	/**
	 * Static Method to sort map via key in both ways
	 * 
	 * @param map
	 *            Map to sort
	 * @param order
	 *            type Ascending or Descending
	 * @return Sorted map
	 */
	public static <K extends Comparable<? super K>, V> Map<K, V> compareByKey(Map<K, V> map, String order) {
		Map<K, V> result = new LinkedHashMap<>();
		if (order.equalsIgnoreCase("ascending")) {
			map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey())
					.forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
		} else if (order.equalsIgnoreCase("descending")) {
			map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByKey().reversed())
					.forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
		}
		return result;
	}

	/**
	 * Static Method to sort map via Value in both ways
	 * 
	 * @param map
	 *            Map to sort
	 * @param order
	 *            type Ascending or Descending
	 * @return Sorted map
	 */
	public static <K, V extends Comparable<? super V>> Map<K, V> compareByValue(Map<K, V> map, String order) {
		Map<K, V> result = new LinkedHashMap<>();
		if (order.equalsIgnoreCase("ascending")) {
			map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByValue())
					.forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
		} else if (order.equalsIgnoreCase("descending")) {
			map.entrySet().stream().sorted(Map.Entry.<K, V>comparingByValue().reversed())
					.forEachOrdered(x -> result.put(x.getKey(), x.getValue()));
		}
		return result;
	}

	/**
	 * Static Method to print the Map
	 * 
	 * @param map
	 *            to print map
	 */
	public static <K, V> void printMap(Map<K, V> map) {
		for (Map.Entry<K, V> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " \tValue : " + entry.getValue());
		}
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
