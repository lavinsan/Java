package java_eight;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vinod Lakhani
 */
public class Item {

	private String fruit;
	private Integer quantity;
	private BigDecimal price;

	public Item() {
	}

	public Item(String fruit, Integer quantity, BigDecimal price) {
		super();
		this.fruit = fruit;
		this.quantity = quantity;
		this.price = price;
	}

	public static List<Item> createItemList() {
		return Arrays.asList(new Item("apple", 10, new BigDecimal("9.99")),
			new Item("banana", 20, new BigDecimal("19.99")),
			new Item("orange", 10, new BigDecimal("29.99")),
			new Item("papaya", 20, new BigDecimal("39.99")),
			new Item("apple", 10, new BigDecimal("9.99")),
			new Item("orange", 10, new BigDecimal("29.99")),
			new Item("orange", 10, new BigDecimal("29.99")),
			new Item("banana", 10, new BigDecimal("19.99")),
			new Item("apple", 20, new BigDecimal("9.99")),
			new Item("orange", 10, new BigDecimal("29.99")),
			new Item("banana", 10, new BigDecimal("19.99")),
			new Item("apple", 20, new BigDecimal("9.99")),
			new Item("banana", 10, new BigDecimal("19.99")),
			new Item("apple", 20, new BigDecimal("9.99")));
	}

	public String getFruit() {
		return fruit;
	}

	public void setFruit(String fruit) {
		this.fruit = fruit;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [fruit=" + fruit + ", quantity=" + quantity + ", price=" + price + "]";
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
