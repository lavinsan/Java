package java_algoridhm;

public class TestingAlgorithm {

	public static void main(String[] args) {

		// Create Array
		int[] array = ArrayUtility.createArray();
		// Print Array
		ArrayUtility.printArray(array);
		
		// Used Selection Sort
		//array = SelectionSort.selectSort(array);
		
		// Used Insertion Sort
		array = InsertionSort.insertSort(array);
		
		//Used Bubble Sort
		//array = BubbleSort.bubbleSort(array);
		
		// Used Merge Sort
		//array = MergeSort.mergeSort(array);
		
		// Print Array
		ArrayUtility.printArray(array);
	}
}