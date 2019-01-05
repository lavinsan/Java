package java_arrays;

import java.util.Arrays;

public class ArrayTwoLargestValue {

	public static void main(String[] args) {
		int[] array = {10, 130, 10, 50, 149, 50, 151, 148, 102, 150};
		Arrays.sort(array);
		twoLargestValue(array);
	}

	private static void twoLargestValue(int[] array) {

		int firstLargest = 0;
		int secondLargest = 0;

		for (int i = 0; i < array.length; i++) {
			if (firstLargest < array[i]) {
				secondLargest = firstLargest;
				firstLargest = array[i];
			} else if (secondLargest < array[i]) {
				secondLargest = array[i];
			}
		}
		System.out.println("First Largest \t : " + firstLargest);
		System.out.println("Second Largest \t :" + secondLargest);
	}

}
