package java_seven;
/*
 * convert string to date
 * we use object of simpledataformat and call parse method 
 * with take string argument and return date object
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDate {
	// StringToDate
	public static void main(String args[]) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dateString = "11/12/2000";
		Date d = sdf.parse(dateString);
		System.out.println(d);
	}
}
