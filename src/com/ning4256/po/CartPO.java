package com.ning4256.po;


public class CartPO {
	private int id;
	private String name;
	private String img;
	private int count;
	private double price;
	
	public CartPO() {
		
	}
	public CartPO(int id, String name, String img, int count, double price) {
		this.id = id;
		this.name = name;
		this.img = img;
		this.count = count;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "CartPO [id=" + id + ", name=" + name + ", img=" + img + ", count=" + count + ", price=" + price + "]";
	}
	
	

	
	
}
