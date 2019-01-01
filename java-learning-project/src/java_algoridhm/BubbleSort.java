package java_algoridhm;

/**
 * Class for Bubble Sort Algorithm
 * 
 * @author Vinod
 */
public class BubbleSort {

	/**
	 * In Bubble sort we push the highest value to the end of list
	 * or to the starting of the list mostly we sort according to
	 * ascending order.
	 * we took two values and check it and then swap it and again
	 * take two value and check it and swap it. this way inner loop
	 * keep swapping the whole index. and outer loop will again
	 * start this process
	 */
	public static int[] bubbleSort(int[] array) {

		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - (i + 1); j++) {
				if (array[j] > array[j + 1]) {
					array = ArrayUtility.swap(array, j, j + 1);
				}
			}
		}

		System.out.println("\nBubble Sorting Algorithm");
		System.out.print("Sorted Array List ---> ");
		return array;
	}
}
