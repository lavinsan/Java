package java_algoridhm;

/**
 * Class for Merge Sort Algorithm
 * 
 * @author Vinod
 *
 */
public class MergeSort {

	/**
	 * Static Method for Merge Sort
	 * 
	 * @param array
	 *            Take an array as input
	 * @return array
	 * 
	 */
	public static int[] mergeSort(int[] array) {

		// check condition to stop recursion
		if (array.length < 2) {
			return array;
		}
		int arrayMid = array.length / 2;
		int[] left = new int[arrayMid];
		int[] right = new int[array.length - arrayMid];

		// Filling left array
		for (int i = 0; i < left.length; i++) {
			left[i] = array[i];
		}
		// System.out.print("Left Array : " +Arrays.toString(left));

		// Filling right array
		for (int i = arrayMid; i < array.length; i++) {
			right[i - arrayMid] = array[i];
		}
		// System.out.println(" Right Array : " +Arrays.toString(right));

		// Recursion methods
		mergeSort(left);
		mergeSort(right);

		// Calling merge method
		array = merge(left, right, array);
		// System.out.println(" Merging Array : " +Arrays.toString(array));
		return array;
	}

	/**
	 * Static Method to sort and merge 2 array
	 * 
	 * @param left
	 *            left array
	 * @param right
	 *            right array
	 * @param array
	 *            main array
	 * @return merged array
	 */
	private static int[] merge(int[] left, int[] right, int[] array) {

		// lenght of array
		int leftLength = left.length;
		int rightLength = right.length;

		// index for all arrays
		int leftIndex = 0, rightIndex = 0, arrayIndex = 0;

		// check left and right array for smaller value and put in main array
		while (leftIndex < leftLength && rightIndex < rightLength) {
			if (left[leftIndex] <= right[rightIndex]) {
				array[arrayIndex] = left[leftIndex];
				leftIndex++;
			} else {
				array[arrayIndex] = right[rightIndex];
				rightIndex++;
			}
			arrayIndex++;
		}

		// check length for left array for left index
		while (leftIndex < leftLength) {
			array[arrayIndex] = left[leftIndex];
			leftIndex++;
			arrayIndex++;
		}

		// check length for right array for left index
		while (rightIndex < rightLength) {
			array[arrayIndex] = right[rightIndex];
			rightIndex++;
			arrayIndex++;
		}
		return array;
	}
}
