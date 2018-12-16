package java_seven;

public class WrapperClassExp {

	public static void main(String[] args) {

		// boxing process using constructor 2 ways
		Integer number1 = new Integer(100);
		Integer number2 = new Integer("200");
		// boxing process using static method valueOF 2 ways
		Integer number3 = Integer.valueOf(300);
		Integer number4 = Integer.valueOf("400");
		// Conversion from string to integer using static method parseInt
		Integer number5 = Integer.parseInt("500");
		// Conversion from integer to string using static method toString
		String number6 = Integer.toString(600);
		String number7 = number2.toString();
		// Unboxing process using xxxValue and toString method.
		int number8 = number1.intValue();

		System.out.println("Number1 \t:\t" + number1);
		System.out.println("Number2 \t:\t" + number2);
		System.out.println("Number3 \t:\t" + number3);
		System.out.println("Number4 \t:\t" + number4);
		System.out.println("Number5 \t:\t" + number5);
		System.out.println("Number6 \t:\t" + number6);
		System.out.println("Number7 \t:\t" + number7);
		System.out.println("Number8 \t:\t" + number8);

		// Exception is raised NumberFormatException is unchecked
		// Can't convert string value to integer value (vinod)
		Integer number9 = Integer.parseInt("vinod");
		System.out.println("Number9 \t:\t" + number9);

	}

}
