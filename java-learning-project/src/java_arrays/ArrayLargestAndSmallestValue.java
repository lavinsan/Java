package java_arrays;

public class ArrayLargestAndSmallestValue {


	public static void main(String[] args) {
		int[] array = {10, 15, 5, 50, 100, 50, 100, 100, 102, 50};
		smallestAndLargestValue(array);
	}

	private static void smallestAndLargestValue(int[] array) {

		int largestValue = array[0];
		int smallestValue = array[0];

		for (int i = 0; i < array.length; i++) {
			if (largestValue < array[i]) {
				largestValue = array[i];
			} else if (smallestValue > array[i]) {
				smallestValue = array[i];
			}
		}
		System.out.println("Largest Value \t : " + largestValue);
		System.out.println("Smallest Value \t : " + smallestValue);
	}

}
