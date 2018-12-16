package java_seven;

public class SingletonClass {
//
	public static void main(String[] args) {
		SingleTon s1 = SingleTon.getInstance();
		System.out.println(s1);
		SingleTon s2 = SingleTon.getInstance();
		System.out.println(s2);
		SingleTon s3 = s1.clone();
		System.out.println(s3);
	}
}

class SingleTon implements Cloneable {
	private static SingleTon single = null;

	private SingleTon() {
	}

	protected SingleTon clone() {
		return single;
	}

	public static SingleTon getInstance() {
		if (single == null) {
			single = new SingleTon();
		}
		return single;
	}
}