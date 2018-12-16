package java_seven;

public class LargestSmallestNumber {

	public static void main(String[] args) {
		int[] list = { 15, 124, 18, 41, 48, 57, 8, -15 };
		largeAndSmallNumber(list);
	}

	public static void largeAndSmallNumber(int[] list) {

		int small = list[0];
		int large = list[0];

		for (int i = 0; i < list.length; i++) {
			if (list[i] > large) {
				large = list[i];
			}
			if (list[i] < small) {
				small = list[i];
			}
		}
		System.out.println(large + "   " + small);
	}

}