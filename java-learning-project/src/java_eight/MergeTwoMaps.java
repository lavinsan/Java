package java_eight;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Vinod Lakhani
 *         1- toMap(keyMapper<Function>, valueMapper<Function>)
 *         2- toMap(keyMapper<Function>, valueMapper<Function>,
 *         mergeFunction<BinaryOperator>)
 *         3- toMap(keyMapper<Function>, valueMapper<Function>,
 *         mergeFunction<BinaryOperator>, mapSupplier<Supplier>)
 */
public class MergeTwoMaps {
	private static Map<Integer, String> map1 = new HashMap<>();
	private static Map<Integer, String> map2 = new HashMap<>();

	public static void main(String[] args) {

		map1.put(1, "deepa");
		map1.put(2, "vinod");
		map1.put(3, "lavina");
		map2.put(4, "karan");
		map2.put(5, "arjun");
		map2.put(2, "vin");

		streamPutAll();
		System.out.println();
		streamMerge();
		System.out.println();
		streamOf();
		System.out.println();
		streamConcat();
		System.out.println();
		mergeFunction();
	}

	// This method will create new map but we can't find duplicates keys value
	// It will replace new value if duplicate key is found
	private static void streamPutAll() {
		System.out.println("streamPutAll");
		Map<Integer, String> map3 = new HashMap<>(map1);
		map3.putAll(map2);
		map3.entrySet()
			.forEach(System.out::println);
	}

	/*
	 * toMap method with 4 Arguments
	 * keyMapper a mapping function to produce keys
	 * valueMapper a mapping function to produce values
	 * mergeFunction used to resolve collisions between values associated with
	 * the same key, as supplied to Map.merge(Object, Object, BiFunction)
	 * we have to decide which value we want old value or new value
	 * mapSupplier a function which returns a new, empty Map into which the
	 * results will be inserted
	 * as we are not passing empty map so both map are merge here
	 * 
	 */
	private static void streamMerge() {
		System.out.println("streamMerge");
		HashMap<Integer, String> map3 =
			map2.entrySet()
				.stream()
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
					(a, b) -> a + " -- " + b, () -> new HashMap<>(map1)));
		map3.entrySet()
			.forEach(System.out::println);
	}

	/*
	 * Using Stream of method giving both maps to this method
	 * converts each map into an entry set --map(map -> map.entrySet())
	 * converts each set into an entry stream --.flatMap(map -> map.stream())
	 * we can combine both step --flatMap(map -> map.entrySet().stream())
	 * then collect and combine with toMap method
	 * toMap(keyMap<Function>,valueMap<Function>,mergeFunction<BinaryOperator>)
	 * keyMapper a mapping function to produce keys
	 * valueMapper a mapping function to produce values
	 * mergeFunction a merge function, used to resolve collisions between values
	 * associated with the same key
	 */
	private static void streamOf() {
		System.out.println("streamOf");
		Map<Integer, String> map3 =
			Stream	.of(map1, map2)
					.map(map -> map.entrySet())
					.flatMap(map -> map.stream())
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(a, b) -> a + " -- " + b));
		map3.entrySet()
			.forEach(System.out::println);
	}

	/*
	 * Using stream concat method giving both maps
	 * but map are given by converting to streams
	 * map1.entrySet().stream()
	 * then rest is same like stream of method
	 */
	private static void streamConcat() {
		System.out.println("streamConcat");
		Map<Integer, String> map3 =
			Stream	.concat(map1.entrySet()
								.stream(),
				map2.entrySet()
					.stream())
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(a, b) -> a + " -- " + b));
		map3.entrySet()
			.forEach(System.out::println);
	}

	/*
	 * Using merge method applicable for map only
	 * creating new map using old map
	 * On second map using iterator (forEach) function
	 * calling merge on new map
	 * merge take 3 arguments
	 * key with which the resulting value is to be associated
	 * value the non-null value to be merged with the existing value associated
	 * with the key or, if no existing value or a null value is associated with
	 * the key, to be associated with the key
	 * remappingFunction the function to recompute a value if present
	 */
	private static void mergeFunction() {
		System.out.println("mergeFunction");
		Map<Integer, String> map3 = new HashMap<>(map1);
		map2.forEach((k, v) -> map3.merge(k, v, (a, b) -> a + " -- " + b));
		map3.entrySet()
			.forEach(System.out::println);
	}
}

/*
 * ToMap -- 4 Arguments
 * 
 * Convert a Map into a Stream
 * Sort it
 * Collect and return a new LinkedHashMap (keep the order)
 * 
 * Map result = map.entrySet().stream()
 * .sorted(Map.Entry.comparingByKey())
 * .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
 * (oldValue, newValue) -> oldValue, LinkedHashMap::new));
 * 
 * 
 */

/*
 * java 9
 * Map<Integer, String> map4 =
 * EntryStream .of(map1)
 * .append(EntryStream.of(map2))
 * .toMap((e1, e2) -> e1);
 */
