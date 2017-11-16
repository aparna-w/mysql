package com.java.test.mysql.transfer;

public class ProductDTO {

	private int id;
	private String title;
	private double weight;
	private double cost;
	private double shipping;
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
	public double getWeight() { return weight; }
	public void setWeight(double weight) { this.weight = weight; }
	
	public double getCost() { return cost; }
	public void setCost(double cost) { this.cost = cost; }
	
	public double getShipping() { return shipping; }
	public void setShipping(double d) { this.shipping = d; }
	
	
	@Override
	public String toString() {
		return "Product [id : " + this.id + ", title : " + this.title + ", weight : " + this.weight + ", cost : " + this.cost + ", shipping : " + this.shipping + "]";
	}

}
