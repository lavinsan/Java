package java_eight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Vinod Lakhani
 *
 */
public class MergeTwoListIntoNewList {
	private static List<String> list1 = new ArrayList<>();
	private static List<String> list2 = new ArrayList<>();

	private static void initialize() {
		list1 = Arrays.asList("vinod", "Mohini");
		list2 = Arrays.asList("vinod", "lavina", "deepa");
	}

	public static void main(String[] args) {
		initialize();
		streamConcat();
		streamOf();
		streamMerge();
	}

	// list merge from addAll and constructor
	private static void streamMerge() {
		List<String> list3 = new ArrayList<>(list1);
		list3.addAll(list2);
		System.out.println(list3);
		System.out.println();
	}

	// list merge from stream of method
	// flatMap convert from List<List<String>> to List<String>
	// then we can collect and convert to another list
	private static void streamOf() {
		List<String> list3 =
			Stream	.of(list1, list2)
					.flatMap((a) -> a.stream())
					.collect(Collectors.toList());
		list3.forEach(System.out::println);
		System.out.println();
	}

	// list merge with stream concat method
	// but concat need stream to concat so list is converted into stream
	// then we can collect and convert to another list
	private static void streamConcat() {
		List<String> list3 =
			Stream	.concat(list1.stream(), list2.stream())
					.collect(Collectors.toList());
		list3.forEach(System.out::println);
		System.out.println();
	}
}
