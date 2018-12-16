package java_multithreading;

/**
 * @author Vinod Lakhani
 *         main thread catch exception thrown by all its child thread
 *         and by itself also
 *         DefaultUncaughtExceptionHandler
 */
public class Exp09UsingDefaultUnCaughtExc {

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(new DefaultUnCaughtExc(), "Thread 1");
		t1.start();

		Thread t2 = new Thread(new DefaultUnCaughtExc(), "Thread 2");
		t2.start();

		Thread.setDefaultUncaughtExceptionHandler(
				new Thread.UncaughtExceptionHandler() {
					@Override
					public void uncaughtException(Thread t, Throwable e) {
						System.out.println(
								"Exception handle by Default Exception Handler");
						System.out.println("Exception in : \t" + t.getName());
						System.out.println(e.getMessage());
					}
				});

		Thread.sleep(1500);

		throw new RuntimeException(" -- Run Time Main Exception -- ");
	}
}
class DefaultUnCaughtExc implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread	.currentThread()
										.getName()
					+ "  : " + (i + 1));
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (i == 5)
				throw new RuntimeException(" -- Run Time Other Exception -- ");
		}
	}
}
