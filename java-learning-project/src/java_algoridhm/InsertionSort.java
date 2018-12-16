package java_algoridhm;

/**
 * Class for Insertion Sort Algorithm
 * 
 * @author Vinod
 *
 */
public class InsertionSort {

	/**
	 * Static method for insertion sort
	 * 
	 * we start from second index and check index before it and if its 
	 * small we keep on swapping till it come to the first index
	 * then the next etc.
	 * 
	 * we use one for loop and one while loop 
	 * for loop just keep looping to next index
	 * while loop will keep on swapping. 
	 */
	public static int[] insertSort(int[] array) {

		int value, index;
		for (int i = 1; i < array.length; i++) {
			value = array[i];
			index = i - 1;
			while (index >= 0 && value < array[index]) {
				array = ArrayUtility.swap(array, index, index + 1);
				index--;
			}
		}
		System.out.println("\nInsertion Sorting Algorithm");
		System.out.print("Sorted Array List ---> ");
		return array;
	}
}
