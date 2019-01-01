package java_algoridhm;

/**
 * Class for Insertion Sort Algorithm
 * 
 * @author Vinod
 */
public class InsertionSort {

	/**
	 * Static method for insertion sort
	 * Insertion sort we pick the second index element and insert it to
	 * its proper place by checking value and swift all the elements to
	 * the left.
	 * we use one for loop and one while loop
	 * for loop just keep looping to next index
	 * while loop will keep on swapping.
	 */
	public static int[] insertSort(int[] array) {

		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					array = ArrayUtility.swap(array, j, j - 1);
				}
			}
		}

		System.out.println("\nInsertion Sorting Algorithm");
		System.out.print("Sorted Array List ---> ");
		return array;
	}
}
