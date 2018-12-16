package java_seven;

import java.io.File;
import java.io.IOException;

public class FileExp {
	public static void main(String[] args) {
		try {
			// To get the class path of the project
			System.out.println(System.getProperty("user.dir"));

			File file = new File("d:\\vinod.txt");

			// To get the path of the file
			System.out.println(file.getAbsolutePath());

			if (file.exists()) {
				System.out.println("Is Execute allow : " + file.canExecute());
				System.out.println("Is Write allow : " + file.canWrite());
				System.out.println("Is Read allow : " + file.canRead());
			}

			file.setExecutable(false);
			file.setReadable(false);
			file.setWritable(false);

			System.out.println("Is Execute allow : " + file.canExecute());
			System.out.println("Is Write allow : " + file.canWrite());
			System.out.println("Is Read allow : " + file.canRead());

			// Return false if exist and true if not exist and also create it
			// createNewFile
			if (file.createNewFile()) {
				System.out.println("File is created!");
			} else {
				System.out.println("File already exists.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
