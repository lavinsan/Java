package java_seven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExp {
	public static void main(String[] args) {

		// try with resources
		// bufferedReader and fileReader used to read file
		try (BufferedReader br = new BufferedReader(new FileReader("d://vinod1.txt"))) {

			String sCurrentLine;

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
