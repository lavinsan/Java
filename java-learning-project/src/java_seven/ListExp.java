package java_seven;
import java.util.Arrays;
import java.util.List;
/**
 * Class to convert array to list using old ways
 * 
 * @author Vinod
 *
 */
public class ListExp {

	public static void main(String[] args) {
		
		// can't use primitive value to convert to list of objects
		// int[] value = new int[] { 15, 6, 19, 10, 12 };
		
		Integer[] value = new Integer[] { 15, 6, 19, 10, 12 };
		List<Integer> list = Arrays.asList(value);
		
		for (Integer data : list) {
			System.out.println("Value is : " + data);
		}
	}

}
