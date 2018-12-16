package java_seven;

public class SumOfTwoNumber {

	public static void main(String[] args) {
		int[] list = { 5, 5, 10, 3, 7, 8, 2, 8 };
		sumNumber(list, 10);
	}

	public static void sumNumber(int[] list, int sum) {

		int first = 0;
		int second = 0;
		for (int i = 0; i < list.length - 1; i++) {
			first = list[i];
			second = list[i + 1];
			if (sum == first + second)
				System.out.println(list[i] + "   " + list[i + 1] + "  " + sum);
		}
	}
}