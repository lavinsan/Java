package java_multithreading;

/**
 * @author Vinod Lakhani
 *         Creating Thread by Anonymous inner class
 *         by using 3 ways
 */
public class Exp03UsingAnonymousClass {

	public static void main(String[] args) {

		// Type 1
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println(Thread	.currentThread()
												.getName()
							+ "  : " + (i + 1));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}, "Thread-1");

		// Type 2
		Thread t2 = new Thread("Thread-2") {
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println(Thread	.currentThread()
												.getName()
							+ "  : " + (i + 1));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		// Type 3
		Runnable r = new Runnable() {
			public void run() {
				for (int i = 0; i < 5; i++) {
					System.out.println(Thread	.currentThread()
												.getName()
							+ "  : " + (i + 1));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};

		Thread t3 = new Thread(r, "Thread-3");

		t1.start();
		t2.start();
		t3.start();
	}

}
