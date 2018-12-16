package java_seven;

public class FactorialOfNumber {

	public static void main(String[] args) {
		System.out.println(factorialNumber(5));
	}

	public static int factorialNumber(int number) {
		int total = 0;
		for (int i = number; i >= 1; i--) {
			total += i;
		}
		return total;
	}
}
