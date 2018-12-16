package java_seven;

public class ReverseNumber {

	public static void main(String[] args) {
		//  using string buffer
		Integer number = 12345;
		StringBuffer b = new StringBuffer(number.toString());
		System.out.println(b.reverse());

		System.out.println(toReverse(number));
	}

	// using proper way
	private static Integer toReverse(Integer number) {
		int reverse = 0;
		while (number != 0) {
			reverse = (reverse * 10) + (number % 10);
			number = number / 10;
		}
		return reverse;
	}
}
