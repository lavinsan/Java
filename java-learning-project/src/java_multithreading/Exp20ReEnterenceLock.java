package java_multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Vinod Lakhani
 *
 */
public class Exp20ReEnterenceLock {

	public static void main(String[] args) throws InterruptedException {

		ProcessReEntrence processReEntrence = new ProcessReEntrence();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processReEntrence.threadOne();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					processReEntrence.threadTwo();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		t1.start();
		t2.start();
		t1.join();
		t2.join();

		System.out.println(processReEntrence.count);
	}
}

class ProcessReEntrence {

	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	int count;

	void increment() {
		count++;
	}
	void threadOne() throws InterruptedException {
		lock.lock();
		System.out.println(" Thread one Got the Lock Going to waiting state ");
		condition.await();
		for (int i = 0; i < 10000; i++) {
			increment();
		}
		System.out.println(" Got signal from lock 2 ");
		lock.unlock();
		System.out.println(" thread one");

	}
	void threadTwo() throws InterruptedException {
		Thread.sleep(100);
		lock.lock();
		System.out.println(" Thread two got the lock giving back the lock ");
		condition.signal();
		for (int i = 0; i < 10000; i++) {
			increment();
		}
		System.out.println(" got signal from lock 1 ");
		lock.unlock();
		System.out.println(" thread two ");
	}
}
