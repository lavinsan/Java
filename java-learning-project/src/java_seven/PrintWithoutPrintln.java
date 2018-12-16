package java_seven;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintWithoutPrintln {

	public static void main(String[] args) throws IOException {

		System.out.println("println----->" + " we are the world");

		System.out.write("write  -----> we are the world \n".getBytes());

		System.out.format("%s", "format -----> we are the world \n");

		System.err.print("err--------->" + " we are the world \n");

		PrintStream myout = new PrintStream(new FileOutputStream(FileDescriptor.out));
		myout.print("printstream->" + " we are the world \n");

		System.console().writer().println("we are the world");
		myout.close();
	}
}
