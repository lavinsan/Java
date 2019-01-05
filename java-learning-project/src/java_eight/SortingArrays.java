package java_eight;

import java.util.Arrays;

public class SortingArrays {

	public static void main(String[] args) {
		int[] array = {10, 15, 10, 50, 100, 50, 100, 100, 102, 50};
		int[] newArray = sortingArray(array);

		for (int i : newArray) {
			System.out.println(i);
		}
	}

	private static int[] sortingArray(int[] array) {

		return Arrays	.stream(array)
						.distinct()
						.toArray();

	}

}
