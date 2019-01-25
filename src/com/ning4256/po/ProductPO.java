package com.ning4256.po;

public class ProductPO {
	private int product_id;
	private int category_id;
	private	String product_name;
	private double product_price;
	private int product_count;
	private String product_pic;
	private String product_description;
	public ProductPO(int product_id, int category_id, String product_name, double product_price, int product_count,
			String product_pic, String product_description) {

		this.product_id = product_id;
		this.category_id = category_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_count = product_count;
		this.product_pic = product_pic;
		this.product_description = product_description;
	}
	public ProductPO() {
		super();
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	public int getProduct_count() {
		return product_count;
	}
	public void setProduct_count(int product_count) {
		this.product_count = product_count;
	}
	public String getProduct_pic() {
		return product_pic;
	}
	public void setProduct_pic(String product_pic) {
		this.product_pic = product_pic;
	}
	public String getProduct_description() {
		return product_description;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	@Override
	public String toString() {
		return "ProductPO [product_id=" + product_id + ", category_id=" + category_id + ", product_name=" + product_name
				+ ", product_price=" + product_price + ", product_count=" + product_count + ", product_pic="
				+ product_pic + ", product_description=" + product_description + "]";
	}
	
	
}
