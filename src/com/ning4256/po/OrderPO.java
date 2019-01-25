package com.ning4256.po;

public class OrderPO {
	
	private String number;
	private String img;
	private String name;
	private Double price;
	private int count;
	private String time;
	public OrderPO(String number, String img, String name, Double price, int count, String time) {
		super();
		this.number = number;
		this.img = img;
		this.name = name;
		this.price = price;
		this.count = count;
		this.time = time;
	}
	public OrderPO() {
		super();
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "OrderPO [number=" + number + ", img=" + img + ", name=" + name + ", price=" + price + ", count=" + count
				+ ", time=" + time + "]";
	}
	
	
}
