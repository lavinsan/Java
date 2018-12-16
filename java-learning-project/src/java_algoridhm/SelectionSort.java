package java_algoridhm;

/**
 * Class for Selection Sort Algorithm
 * 
 * @author Vinod
 *
 */
public class SelectionSort {

	/**
	 * Static method for Selection sort
	 * 
	 * we will select minimum value in the array and then swap with first
	 * index and then again select second minimum value and swap to second
	 * index we keep on doing till array is not sorted.
	 * 
	 * we use two for loops. the inner loop will find the minimum value 
	 * and outer loop will swap the value and go to next index.
	 */
	public static int[] selectSort(int[] array) {
		
		int minValue;
		for (int i = 0; i < array.length - 1; i++) {
			minValue = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[minValue] > array[j]) {
					minValue = j;
				}
			}
			array = ArrayUtility.swap(array, minValue, i);
		}
		System.out.println("\nSelection Sorting Algorithm");
		System.out.print("Sorted Array List ---> ");
		return array;
	}
}
