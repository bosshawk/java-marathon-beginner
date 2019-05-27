package com.example.domain;

public class Item {

	/** 名前 */
	private String name;

	/** 価格 */
	private Integer price;

	@Override
	public String toString() {
		return "Item [name=" + name + ", price=" + price + "]";
	}

	public Item() {
	}

	public Item(String name, Integer price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
