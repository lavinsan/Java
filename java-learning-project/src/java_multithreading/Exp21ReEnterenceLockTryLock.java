package java_multithreading;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Vinod Lakhani
 *
 */
public class Exp21ReEnterenceLockTryLock {

	public static void main(String[] args) throws InterruptedException {

		ProcessReEntrence1 processReEntrence = new ProcessReEntrence1();

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
		processReEntrence.balancePrint();
	}
}

class ProcessReEntrence1 {

	Account one = new Account();
	Account two = new Account();
	Random random = new Random();

	Lock lock = new ReentrantLock();

	void threadOne() throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			lock.lock();
			Account.transfer(one, two, random.nextInt(1000));
			lock.unlock();
		}
	}
	void threadTwo() throws InterruptedException {
		for (int i = 0; i < 100; i++) {
			lock.lock();
			Account.transfer(two, one, random.nextInt(1000));
			lock.unlock();
		}
	}
	void balancePrint() {
		System.out.println(" First  Balance : " + one.getBalance());
		System.out.println(" Second Balance : " + two.getBalance());
		System.out.println(
				" Total  Balance : " + (one.getBalance() + two.getBalance()));
	}

}

class Account {

	private int balance = 10000;

	private void deposit(int value) {
		balance = balance + value;
	}
	private void withdraw(int value) {
		balance = balance - value;
	}
	public int getBalance() {
		return balance;
	}
	public static void transfer(Account one, Account two, int amount) {
		one.deposit(amount);
		two.withdraw(amount);
	}
}
