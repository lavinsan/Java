package java_seven;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Class To check all type of map using old ways
 * 
 * @author Vinod
 *
 */
public class MapExp {

	static Map<Integer, String> unsortMap = new LinkedHashMap<>();

	public static void main(String[] args) {
		// To insert data in the map
		createMap();

		// Printing the LinkedHashMap where order is maintained
		System.out.println("Map Using Linked HashMap ....... Order is maintain");
		printMap(unsortMap);

		// Printing the HashMap where order is not maintained
		System.out.println("\nMap Using HashMap ....... UnOrdered");
		Map<Integer, String> hashMap = new HashMap<>(unsortMap);
		printMap(hashMap);

		// Printing the TreeMap in Sorted order -Ascending order
		System.out.println("\nMap Using TreeMap....... Sorted in Ascending");
		Map<Integer, String> treeMap = new TreeMap<>(unsortMap);
		printMap(treeMap);

		// Printing the TreeMap in Sorted order - Descending order
		System.out.println("\nMap Using TreeMap....... Sorted in descending");
		Map<Integer, String> treeMap1 = new TreeMap<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer one, Integer two) {
				return two.compareTo(one);
			}
		});
		treeMap1.putAll(unsortMap);
		printMap(treeMap1);

		// Printing the TreeMap in Sorted order - ByValue
		System.out.println("\nMap Using TreeMap....... Sorted by Value");
		Map<Integer, String> treeMap2 = new TreeMap<>(unsortMap);
		treeMap2 = sortByValue(treeMap2);
		printMap(treeMap2);
	}

	/**
	 * Static Method to sorted by value
	 * 
	 * @param map
	 *            Take the map to sort
	 * @return Sorted map by value is return
	 */
	private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {

		// Create List of type Map.Entry and give as parameter map.entryset
		List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());

		// Sort the list with sort method using comparator
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Entry<K, V> one, Entry<K, V> two) {
				return one.getValue().compareTo(two.getValue());
			}
		});

		// create another map and put all records in it using list
		Map<K, V> returnMap = new LinkedHashMap<>();
		for (Map.Entry<K, V> entry : list) {
			returnMap.put(entry.getKey(), entry.getValue());
		}
		return returnMap;
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
		// Old way using Iterator
		// Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
		// while (it.hasNext()) {
		// Map.Entry<K, V> entry = it.next();
		// System.out.println(entry.getKey() + " " + entry.getValue()); }
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
