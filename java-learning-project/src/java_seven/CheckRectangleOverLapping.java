package java_seven;

public class CheckRectangleOverLapping {
	//  Two rectangle to check
	public static void main(String[] args) {

		Point l1 = new Point(0, 10);
		Point r1 = new Point(10, 0);
		Point l2 = new Point(5, 5);
		Point r2 = new Point(15, 0);

		Rectangle rec1 = new Rectangle(l1, r1);
		Rectangle rec2 = new Rectangle(l2, r2);

		if (rec1.isOverLapping(rec2)) {
			System.out.println("is overlapping");
		} else {
			System.out.println("no overlapping");
		}
	}
}

class Point {
	int left, right;

	Point(int left, int right) {
		this.left = left;
		this.right = right;
	}
}

class Rectangle {
	Point topLeft, bottomRight;

	public Rectangle(Point topLeft, Point bottomRight) {
		super();
		this.topLeft = topLeft;
		this.bottomRight = bottomRight;
	}

	public boolean isOverLapping(Rectangle other) {
		if (this.topLeft.left > other.bottomRight.left || this.bottomRight.left < other.topLeft.left
				|| this.topLeft.right < other.bottomRight.right || this.bottomRight.right > other.topLeft.right) {
			return false;
		}
		return true;
	}
}