package java_multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Vinod Lakhani
 *         CountDownLatch is a thread safe class to count latch
 *         latch are count down to zero from the value its given at starting
 *         we can await for the count down
 */
public class Exp17CoutDownLatch {

	public static void main(String[] args) {

		CountDownLatch latch = new CountDownLatch(5);
		ExecutorService executor = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 5; i++) {
			executor.submit(new Processor1(i, latch));
		}

		executor.shutdown();

		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" Process completed ");
	}

}

class Processor1 implements Runnable {

	private int id;
	private CountDownLatch latch;

	public Processor1(int id, CountDownLatch latch) {
		super();
		this.id = id;
		this.latch = latch;
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
		latch.countDown();
	}

}