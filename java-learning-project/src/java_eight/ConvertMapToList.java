package java_eight;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertMapToList {

	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<>();
		map.put(10, "apple");
		map.put(20, "orange");
		map.put(30, "banana");
		map.put(40, "watermelon");
		map.put(50, "dragonfruit");

		// Export Map Key to List
		List<Integer> result1 = new ArrayList<>(map.keySet());
		result1.forEach(System.out::println);
		System.out.println();

		// Export Map Value to List
		List<String> result2 = new ArrayList<>(map.values());
		result2.forEach(System.out::println);
		System.out.println();

		// Export Map Key to List
		List<Integer> result3 =
			map	.keySet()
				.stream()
				.collect(Collectors.toList());
		result3.forEach(System.out::println);
		System.out.println();

		// Export Map Value to List
		List<String> result4 =
			map	.values()
				.stream()
				.collect(Collectors.toList());
		result4.forEach(System.out::println);
		System.out.println();

		// Export Map Value to List..., say no to banana")
		List<String> result5 =
			map	.values()
				.stream()
				.filter(x -> !"banana".equalsIgnoreCase(x))
				.collect(Collectors.toList());
		result5.forEach(System.out::println);
		System.out.println();

		//
		List<Integer> resultSortedKey = new ArrayList<>();
		List<String> resultValues =
			map	.entrySet()
				.stream()
				// sort a Map by key and stored in resultSortedKey
				.sorted(Map.Entry	.<Integer, String>comparingByKey()
									.reversed())
				.peek(e -> resultSortedKey.add(e.getKey()))
				.map(x -> x.getValue())
				// filter banana and return it to resultValues
				.filter(x -> !"banana".equalsIgnoreCase(x))
				.collect(Collectors.toList());

		resultSortedKey.forEach(System.out::println);
		System.out.println();
		resultValues.forEach(System.out::println);
		System.out.println();

		// Sorting can be done in two ways
		// 1-- .sorted(Map.Entry .<Integer,String>comparingByValue().reversed())
		// 2-- .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
		// We can use map and peek also to store data to list but we need
		// terminal operation
		// .map(m -> list.add(m.getKey().toString() + " " + m.getValue()))
		// .peek(m -> list.add(m .getKey().toString()+ " " + m.getValue()))
		List<String> list = new ArrayList<>();
		map	.entrySet()
			.stream()
			.sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
			.forEachOrdered(m -> list.add(m	.getKey()
											.toString()
				+ " " + m.getValue()));
		list.forEach(System.out::println);

	}

}
