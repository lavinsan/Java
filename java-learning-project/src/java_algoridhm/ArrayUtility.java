package java_algoridhm;

/**
 * Utility Class to create Array, print Array, swap elements
 * 
 * @author Vinod
 *
 */
public class ArrayUtility {

	/**
	 * Static method to create array of 10 random value
	 * 
	 * @return Array of integer
	 */
	public static int[] createArray() {
		int[] array = new int[10];
		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * 10) + 10;
		}
		System.out.print(" Unsorted Array List ---> ");
		return array;
	}

	/**
	 * Static method to print array
	 * 
	 * @param array
	 *            Input Integer array to print
	 */
	public static void printArray(int[] array) {
		printLine();
		System.out.print("|| ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(i + "  || ");
		}
		printLine();
		System.out.print("|| ");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " || ");
		}
		printLine();
	}

	/**
	 * Static method for swapping the value in array
	 * 
	 * @param array
	 *            Array to swap values
	 * @param one
	 *            Value one to swap with value two
	 * @param two
	 *            Value two to swap with value one
	 * @return Swap Array
	 */
	public static int[] swap(int[] array, int one, int two) {
		int temp = array[one];
		array[one] = array[two];
		array[two] = temp;
		return array;
	}

	/**
	 * Print line in the array
	 */
	private static void printLine() {
		System.out.println();
		for (int i = 0; i < 62; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
}
