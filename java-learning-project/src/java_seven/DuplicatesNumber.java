package java_seven;

import java.util.Arrays;

public class DuplicatesNumber {

	public static void main(String[] args) {
		int[] a = { 3, 2, 1, 4, 7, 7, 5, 1, 4, 5 };
		Arrays.sort(a);
		System.out.println(a.length);
		int count = 0;

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			if (i + 1 < a.length && a[i] == a[i + 1]) {
			} else {
				count++;
			}
		}

		System.out.println("\n" + count);
		int[] b = new int[count];

		int counter = 0;
		for (int i = 0; i < a.length; i++) {
			if (i + 1 < a.length && a[i] == a[i + 1]) {
			} else {
				b[counter] = a[i];
				counter++;
			}
		}

		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i]);
		}
	}
}
