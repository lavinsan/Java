package java_multithreading;

/**
 * @author Vinod Lakhani
 *         we can catch exception by ThreadGroup also
 *         by Overriding uncaughtException in thread group inner class
 */
public class Exp11UsingThreadGroupUnCaughtExc {

	public static void main(String[] args) {

		ThreadGroup tg1 = new ThreadGroup("Group 1") {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println(
						"Exception handle by ThreadGroup Exception Handler");
				System.out.println("Exception in Thread : \t" + t.getName());
				System.out.println(e.getMessage());
			}
		};
		Thread t1 = new Thread(tg1, new TGUnCaughtExc(), "Thread 1");
		t1.start();

	}
}
class TGUnCaughtExc implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread	.currentThread()
										.getName()
					+ "  : " + (i + 1));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (i == 5)
				throw new RuntimeException(" -- Run Time Other Exception -- ");
		}
	}
}
