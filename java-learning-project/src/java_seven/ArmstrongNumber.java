package java_seven;

public class ArmstrongNumber {

	public static void main(String[] args) {

		String nextLine = "371";
		int length = nextLine.length();
		Integer number = Integer.valueOf(nextLine);
		int newNumber = 0;
		int pow = 0;
		for (int i = 0; i < length; i++) {
			newNumber = number % 10;
			pow = pow + (int) Math.pow(newNumber, length);
			number = number / 10;
		}
		System.out.println(pow);
	}

}
