package java_eight;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Vinod Lakhani
 *
 */
public class ItemGroupingAndMapping {

	public static void main(String[] args) {

		List<Item> itemList = Item.createItemList();

		System.out.println("\n---Grouping by Fruits (1 Argument)-----------------");
		System.out.println("Return Map of Fruits and List of Item--------------\n");
		Map<String, List<Item>> fruitList =
			itemList.stream()
					.collect(Collectors.groupingBy(Item::getFruit));
		fruitList.forEach((k, v) -> System.out.println(k + " \t " + v));

		System.out.println("\n---Grouping by Price (2 Argument)------------------");
		System.out.println("Mapping by fruits and converted to set --------------");
		System.out.println("Return Map of price and set of fruits--------------\n");
		Map<BigDecimal, Set<String>> fruitSet =
			itemList.stream()
					.collect(Collectors.groupingBy(Item::getPrice,
						Collectors.mapping(Item::getFruit, Collectors.toSet())));
		fruitSet.forEach((k, v) -> System.out.println(k + " \t " + v));

		System.out.println("\n---Grouping by Fruits (2 Argument)-----------------");
		System.out.println("Return Map of Fruits and Counting number-----------\n");
		Map<String, Long> counting =
			itemList.stream()
					.collect(Collectors.groupingBy(Item::getFruit, // function.identity
						Collectors.counting()));// counting
		counting.forEach((k, v) -> System.out.println(k + " \t " + v));

		System.out.println("\n---Grouping by Fruits (2 Argument)-----------------");
		System.out.println("Return Map of Fruits and Sum of Qty----------------\n");
		Map<String, Integer> summing =
			itemList.stream()
					.collect(Collectors.groupingBy(Item::getFruit, // function.identity
						Collectors.summingInt(Item::getQuantity)));// sum
		summing.forEach((k, v) -> System.out.println(k + " \t " + v));

		System.out.println("\n---Sorting Map By Value----------------------------");
		Map<String, Long> result = new LinkedHashMap<>();
		counting.entrySet()
				.stream()
				.sorted(comparingValueOfMap().reversed())
				.forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
		result.forEach((k, v) -> System.out.println(k + " \t " + v));

	}

	private static Comparator<? super Entry<String, Long>> comparingValueOfMap() {
		return (k1, k2) -> k1	.getValue()
								.compareTo(k2.getValue());
	}

}
/*
 * // Accumulate names into a List
 * List<String> list =
 * people.stream().map(Person::getName).collect(Collectors.toList());
 * 
 * // Accumulate names into a TreeSet
 * Set<String> set =
 * people.stream().map(Person::getName).collect(Collectors.toCollection(TreeSet:
 * :new));
 * 
 * // Convert elements to strings and concatenate them, separated by commas
 * String joined = things.stream()
 * .map(Object::toString)
 * .collect(Collectors.joining(", "));
 * 
 * // Compute sum of salaries of employee
 * int total = employees.stream()
 * .collect(Collectors.summingInt(Employee::getSalary)));
 * 
 * // Group employees by department
 * Map<Department, List<Employee>> byDept
 * = employees.stream()
 * .collect(Collectors.groupingBy(Employee::getDepartment));
 * 
 * // Compute sum of salaries by department
 * Map<Department, Integer> totalByDept
 * = employees.stream()
 * .collect(Collectors.groupingBy(Employee::getDepartment,
 * Collectors.summingInt(Employee::getSalary)));
 * 
 * // Partition students into passing and failing
 * Map<Boolean, List<Student>> passingFailing =
 * students.stream()
 * .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));
 * 
 */
