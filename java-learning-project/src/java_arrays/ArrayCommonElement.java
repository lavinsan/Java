package java_arrays;

import java.util.Arrays;

public class ArrayCommonElement {

	public static void main(String[] args) {
		int[] array1 = {10, 15, 5, 50, 103, 52, 100, 101, 102, 54};
		int[] array2 = {106, 53, 100, 102, 50, 25, 35, 18, 24, 85};
		Arrays.sort(array1);
		Arrays.sort(array2);
		commonElement(array1, array2);
	}

	private static void commonElement(int[] array1, int[] array2) {
		for (int i = 0; i < array1.length; i++) {
			for (int j = 0; j < array2.length; j++) {
				if (array1[i] == array2[j]) {
					System.out.println(array1[i]);
				}
			}
		}
	}

}
