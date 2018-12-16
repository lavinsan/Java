package java_eight;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vinod Lakhani
 *
 */
public class User {

	private Integer id;
	private String name;
	private Integer age;
	private BigDecimal salary;
	private List<Integer> phone;

	public static List<User> createUser() {
		return Arrays.asList(new User(1, "vinod", 45, new BigDecimal(50000), Arrays.asList(1, 2)),
			new User(2, "deepa", 42, new BigDecimal(50000), Arrays.asList(3, 4, 5)),
			new User(3, "lavina", 16, new BigDecimal(50000), Arrays.asList(6)),
			new User(4, "mohini", 70, new BigDecimal(50000), Arrays.asList(7, 8)));
	}

	public User() {
		super();
	}

	public User(Integer id, String name, Integer age, BigDecimal salary, List<Integer> phone) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public List<Integer> getPhone() {
		return phone;
	}

	public void setPhone(List<Integer> phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary
			+ ", phone=" + phone + "]";
	}

}
