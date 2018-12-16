package java_multithreading;

/**
 * @author Vinod Lakhani
 *         It will catch current class exception thrown in thread
 *         UncaughtExceptionHandler
 */
public class Exp10UsingUnCaughtExc {

	public static void main(String[] args) {

		Thread	.currentThread()
				.setUncaughtExceptionHandler(
						new Thread.UncaughtExceptionHandler() {
							@Override
							public void uncaughtException(Thread t,
									Throwable e) {
								System.out.println(
										"Exception handle by Uncaught Exception Handler");
								System.out.println("Exception in Thread : \t"
										+ t.getName());
								System.out.println(e.getMessage());
							}
						});

		throw new RuntimeException(" -- Current class Exception -- ");

	}
}
