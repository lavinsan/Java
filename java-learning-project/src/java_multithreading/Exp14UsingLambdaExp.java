package java_multithreading;

/**
 * @author Vinod Lakhani
 *         Creating Thread by Anonymous inner class
 *         by using 3 ways
 */
public class Exp14UsingLambdaExp {

	public static void main(String[] args) {

		// Type 1
		Thread t1 = new Thread(() -> {
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
		}, "Thread-1");

		// Type 2
		Runnable r = () -> {
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
		};

		Thread t2 = new Thread(r, "Thread-2");

		t1.start();
		t2.start();
	}

}
