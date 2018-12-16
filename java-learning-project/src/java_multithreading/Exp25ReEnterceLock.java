package java_multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Vinod Lakhani
 *
 */
public class Exp25ReEnterceLock {

	public static void main(String[] args) {

		Mycounter counter = new Mycounter();

		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					counter.increment();
				}
			}
		};
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 2000; i++) {
					counter.increment();
				}
			}
		};

		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(2);
			service.submit(r1);
			service.submit(r2);
		} catch (Exception e) {
			e.getMessage();
		} finally {
			service.shutdown();
		}
		
		try {
			service.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(counter.getCounter());
	}

}

class Mycounter {

	Lock lock = new ReentrantLock();
	private int counter;

	public void increment() {
		lock.lock();
		try {
			counter++;
		} finally {
			lock.unlock();
		}
	}
	public int getCounter() {
		return counter;
	}
}