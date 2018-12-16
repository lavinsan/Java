package java_multithreading;

/**
 * @author Vinod Lakhani
 *         In deadlock we can check by using java visual vm tools in bin.
 *         Or in command prompt we can write jps -l -m to find process number
 *         then we write jstack and process number
 */
public class Exp05DeadLock {

	public static void main(String[] args) {

		Object lock1 = new Object();
		Object lock2 = new Object();

		Thread t1 = new Thread(new DeadLock1(lock1, lock2), "Thread-1");
		Thread t2 = new Thread(new DeadLock2(lock1, lock2), "Thread-2");

		t1.start();
		t2.start();
	}
}
class DeadLock1 implements Runnable {

	Object lock1;
	Object lock2;

	public DeadLock1(Object lock1, Object lock2) {
		super();
		this.lock1 = lock1;
		this.lock2 = lock2;
	}

	@Override
	public void run() {

		synchronized (lock1) {

			System.out.println(Thread	.currentThread()
										.getName()
					+ " Lock-1");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (lock2) {
				System.out.println(Thread	.currentThread()
											.getName()
						+ " Lock-2");
			}
		}
	}
}

class DeadLock2 implements Runnable {

	Object lock1;
	Object lock2;

	public DeadLock2(Object lock1, Object lock2) {
		super();
		this.lock1 = lock1;
		this.lock2 = lock2;
	}

	@Override
	public void run() {

		synchronized (lock2) {

			System.out.println(Thread	.currentThread()
										.getName()
					+ " Lock-2");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			synchronized (lock1) {
				System.out.println(Thread	.currentThread()
											.getName()
						+ " Lock-1");
			}
		}
	}
}
