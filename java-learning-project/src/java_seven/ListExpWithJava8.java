package java_seven;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * Class to convert array to list using java 8 and stream api
 * 
 * @author Vinod
 *
 */
public class ListExpWithJava8 {

	public static void main(String[] args) {

		// Primitive array to list
		// Arrays --- Stream --- Boxed --- collect --- forEach
		int[] value1 = new int[] { 15, 6, 19, 10, 12 };
		List<Integer> list1 = Arrays.stream(value1).boxed().collect(Collectors.toList());
		list1.forEach(x -> System.out.println("Value is : " + x));
		System.out.println();

		// Object array to list
		// Arrays --- Stream --- collect --- forEach
		Integer[] value2 = new Integer[] { 15, 6, 19, 10, 12 };
		List<Integer> list2 = Arrays.stream(value2).collect(Collectors.toList());
		list2.forEach(x -> System.out.println("Value is : " + x));
		System.out.println();

		// Stream collection to list
		// collect --- forEach
		Stream<Integer> value3 = Stream.of(15, 6, 19, 10, 12);
		List<Integer> list3 = value3.collect(Collectors.toList());
		list3.forEach(x -> System.out.println("Value is : " + x));
		System.out.println();

		// Stream collection to list with condition
		// filter --- collect --- forEach
		Stream<Integer> value4 = Stream.of(15, 6, 19, 10, 12);
		List<Integer> list4 = value4.filter(x -> x != 10).collect(Collectors.toList());
		list4.forEach(x -> System.out.println("Value is : " + x));
		System.out.println();
	}

}
