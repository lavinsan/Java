package java_multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Vinod Lakhani
 *         ExecutorService is a Thread pool service to get fixed number of
 *         services so we can do task. and thread are re used.
 *         we can shutdown the service
 *         we can awaitTermination for time period to complete all the task
 */
public class Exp16ExecutorService {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(2);

		for (int i = 0; i < 5; i++) {
			executor.submit(new Processor(i));
		}

		executor.shutdown();

		try {
			executor.awaitTermination(5, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(" Process completed ");
	}

}

class Processor implements Runnable {

	private int id;

	public Processor(int id) {
		super();
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println(" Process Started : \t" + id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" Process Ended   : \t" + id);
	}
}