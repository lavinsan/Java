package java_seven;

import java.util.Arrays;
import java.util.List;

public class AverageOfNumberInList {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(7, 8, 7, 4, 5, 9, 7, 8, 2, 3);
		averageOfList(numbers);
		System.out.println(averageOfListJava8(numbers));
	}

	public static void averageOfList(List<Integer> list) {
		int total = 0;
		int count = 0;
		for (int i : list) {
			count++;
			total += i;
		}
		System.out.println(total + "  " + count + "  " + total / count);
	}

	public static double averageOfListJava8(List<Integer> list) {
		return list.stream()
					.mapToInt(e -> e)
					.average()
					.getAsDouble();
	}
}
