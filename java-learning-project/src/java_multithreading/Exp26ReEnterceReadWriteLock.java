package java_multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Vinod Lakhani
 *
 */
public class Exp26ReEnterceReadWriteLock {

	public static void main(String[] args) {

		MyNewcounter counter = new MyNewcounter();

		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 100000; i++) {
					counter.increment();
				}
			}
		};
		
		Runnable r2 = new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 50000; i++) {
					counter.increment();
				}
			}
		};
		
		Runnable r3 = new Runnable() {
			@Override
			public void run() {
				System.out.println(counter.getCounter());
			}
		};
		
		Runnable r4 = new Runnable() {
			@Override
			public void run() {
				System.out.println(counter.getCounter());
			}
		};
		ExecutorService service = null;
		try {
			service = Executors.newFixedThreadPool(2);
			service.submit(r1);
			service.submit(r2);
			service.awaitTermination(5, TimeUnit.SECONDS);
			service.submit(r3);
			service.submit(r4);
		} catch (Exception e) {
			e.getMessage();
		} finally {
			service.shutdown();
		}
	}
}

class MyNewcounter {

	ReadWriteLock lock = new ReentrantReadWriteLock(true);
	private int counter;

	public void increment() {
		lock.writeLock()
			.lock();
		try {
			counter++;
		} finally {
			lock.writeLock()
				.unlock();
		}
	}
	public int getCounter() {
		lock.readLock()
			.lock();
		try {
			return counter;
		} finally {
			lock.readLock()
				.unlock();
		}
	}
}