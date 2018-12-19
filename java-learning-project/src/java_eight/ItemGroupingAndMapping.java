package java_eight;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Vinod Lakhani
 *         groupingBy(Function<Classifier>)
 *         groupingBy(Function<Classifier>, Collector<Downstream>)
 *         groupingBy(Function<Classifier>, Supplier<MapFactory>, Collector<D>)
 *         mapping(Function<mapper>, Collector<downstream>)
 */
public class ItemGroupingAndMapping {

	public static void main(String[] args) {

		List<Item> itemList = Item.createItemList();

		// groupingBy(Function<Classifier>)
		// (1 Argument) 1- Grouping by Fruits
		// Return Map of Fruits and number of list of Item in each fruit
		Map<String, List<Item>> fruitList =
			itemList.stream()
					.collect(Collectors.groupingBy(Item::getFruit));
		fruitList.forEach((k, v) -> System.out.println(k + " \t " + v));
		System.out.println();

		// *** groupingBy(Function<Classifier>, Collector<Downstream>)
		// (2 Argument) 1- Grouping by Price 2- Argument is collector
		// second argument is mapping function takes again 2 arguments
		// *** mapping(Function<mapper>, Collector<downstream>)
		// 1- Mapping by fruits 2- converted to set
		// Return Map of price and set of fruits
		Map<BigDecimal, Set<String>> fruitSet =
			itemList.stream()
					.collect(Collectors.groupingBy(Item::getPrice,
						Collectors.mapping(Item::getFruit, Collectors.toSet())));
		fruitSet.forEach((k, v) -> System.out.println(k + " \t " + v));
		System.out.println();

		// *** groupingBy(Function<Classifier>, Collector<Downstream>)
		// (2 Argument) 1- Grouping by fruit 2- Argument is collector
		// 1- Grouping by Fruits 2- Argument is collector.counting
		// Return Map of Fruits and Counting number
		Map<String, Long> counting =
			itemList.stream()
					.collect(Collectors.groupingBy(Item::getFruit, // Function.identity
						Collectors.counting()));// counting
		counting.forEach((k, v) -> System.out.println(k + " \t " + v));
		System.out.println();

		// *** groupingBy(Function<Classifier>, Collector<Downstream>)
		// (2 Argument) 1- Grouping by fruit 2- Argument is collector
		// 1- Grouping by Fruits 2- Argument is collector.summingInt
		// Return Map of Fruits and Sum of Qty each fruit has
		Map<String, Integer> summing =
			itemList.stream()
					.collect(Collectors.groupingBy(Item::getFruit, // function.identity
						Collectors.summingInt(Item::getQuantity)));// sum
		summing.forEach((k, v) -> System.out.println(k + " \t " + v));
		System.out.println();

		// Here Function identity means list of Strings
		List<String> items =
			Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
		Map<String, Long> result =
			items	.stream()
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		result	.entrySet()
				.forEach(System.out::println);
		System.out.println();
		
		//Creating new map sorting by Value  
		Map<String, Long> newMap = new LinkedHashMap<>();
		result.entrySet()
				.stream()
				.sorted(comparingValueOfMap().reversed())
				.forEachOrdered(e -> newMap.put(e.getKey(), e.getValue()));
		newMap.forEach((k, v) -> System.out.println(k + " \t " + v));
		System.out.println();
	}

	private static Comparator<? super Entry<String, Long>> comparingValueOfMap() {
		return (k1, k2) -> k1	.getValue()
								.compareTo(k2.getValue());
	}
}

