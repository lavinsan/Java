package java_seven;

import java.util.Arrays;
import java.util.List;

public class MaxValueInList {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(6, 8, 3, 4, 5, 9, 7, 8, 2, 3);
		maxValueInList(numbers);
		maxValueInListNew(numbers);
	}

	public static void maxValueInList(List<Integer> list) {
		int value = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) >= value)
				value = list.get(i);
		}
		System.out.println(value);
	}

	public static void maxValueInListNew(List<Integer> list) {
		int maxi = list.get(0);
		for (int m : list) {
			if (maxi < m)
				maxi = m;
		}
		System.out.println(maxi);
	}
}
