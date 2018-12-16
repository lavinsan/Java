package java_seven;
/*
 *  there are 2 ways 
 *  using integer.parseint("String",regix)
 *  your own logic
 */
public class BinaryToDecimal {

	public static void main(String[] args) {
		// System.out.println(Integer.parseInt("1101",2));
		int binary = 100;
		int tmp = binary;
		int decimal = 0;
		int power = 0;
		while (true) {
			if (binary == 0) {
				break;
			} else {
				decimal += (binary % 10) * Math.pow(2, power);
				binary = binary / 10;
				power++;
			}
		}
		System.out.println("Binary=" + tmp + " Decimal=" + decimal);
	}
}
