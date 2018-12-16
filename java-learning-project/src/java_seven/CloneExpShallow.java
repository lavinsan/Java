package java_seven;

/**
 * @author lavin
 *         step 1 implements clonable interface
 *         step 2 override clone method calling super clone method
 *         step 3 it throws checked exception CloneNotSupporedException
 *         this is shallow cloning as only original object is cloned
 *         but reference object is not cloned.
 */

class Address {
	String address = "usa";
}
class Employee implements Cloneable {

	String name;
	String id;
	Address add;

	public String toString() {
		return "[name=" + name + ", id=" + id + "]";
	}

	public Employee(String name, String id) {
		super();
		this.name = name;
		this.id = id;
		add = new Address();
	}

	public Employee clone() throws CloneNotSupportedException {
		return (Employee) super.clone();
	}

}

public class CloneExpShallow {

	public static void main(String[] args) throws CloneNotSupportedException {

		Employee emp1 = new Employee("vinod", "a123");
		System.out.println("Employee 1 :\t" + emp1);
		System.out.println("Employee 1 :\t" + emp1.hashCode());
		System.out.println("Employee 1 :\t" + emp1.add.hashCode());

		Employee emp2 = emp1.clone();
		System.out.println("Employee 2 :\t" + emp2);
		System.out.println("Employee 2 :\t" + emp2.hashCode());
		System.out.println("Employee 2 :\t" + emp2.add.hashCode());
		
	}

}
