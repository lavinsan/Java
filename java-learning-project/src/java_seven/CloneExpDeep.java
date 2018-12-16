package java_seven;
/**
 * @author lavin
 *         step 1 implements clonable interface
 *         step 2 override clone method calling super clone method
 *         step 3 it throws checked exception CloneNotSupporedException
 *         this is deep cloning as original object is cloned
 *         and reference object is also cloned.
 */
class Address1 implements Cloneable {
	String add = "usa";

	public Address1 clone() throws CloneNotSupportedException {
		return (Address1) super.clone();
	}
}

class Employee1 implements Cloneable {
	String name;
	String id;
	Address1 add1;

	public Employee1(String name, String id) {
		super();
		this.name = name;
		this.id = id;
		add1 = new Address1();
	}

	@Override
	public String toString() {
		return "[name=" + name + ", id=" + id + "]";
	}

	public Employee1 clone() throws CloneNotSupportedException {
		Employee1 e = (Employee1) super.clone();
		e.add1 = add1.clone();
		return e;
	}
}

public class CloneExpDeep {

	public static void main(String[] args) throws CloneNotSupportedException {
		Employee1 emp1 = new Employee1("vinod", "a123");
		System.out.println("Employee 1 :\t" + emp1);
		System.out.println("Employee 1 :\t" + emp1.hashCode());
		System.out.println("Employee 1 :\t" + emp1.add1.hashCode());

		Employee1 emp2 = emp1.clone();
		System.out.println("Employee 2 :\t" + emp2);
		System.out.println("Employee 2 :\t" + emp2.hashCode());
		System.out.println("Employee 2 :\t" + emp2.add1.hashCode());
	}

}
