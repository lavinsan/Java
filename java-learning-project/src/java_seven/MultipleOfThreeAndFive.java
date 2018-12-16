package java_seven;

public class MultipleOfThreeAndFive {

	public static void main(String[] args) {
		System.out.println(multiple(15));
	}

	static int multiple(int number) {
		int total = 0;
		for (int i = 1; i < number; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				total += i;
			}
		}
		return total;
	}
}
