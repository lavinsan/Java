package java_multithreading;

/**
 * @author Vinod Lakhani
 */
public class Exp12UsingYeildMethod {

	public static void main(String[] args) {
		
		RunnableYeild r1 = new RunnableYeild();
		Thread t1 = new Thread(r1, "Thread-1");
		Thread t2 = new Thread(r1, "Thread-2");
		
		t1.start();
		t2.start();
	}
}
class RunnableYeild implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread	.currentThread()
										.getName()
					+ "  : " + (i + 1));

			if ("Thread-1".equals(Thread.currentThread()
										.getName()))
				Thread.yield();

		}
	}
}
