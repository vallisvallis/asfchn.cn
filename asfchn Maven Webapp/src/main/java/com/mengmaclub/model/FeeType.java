package com.mengmaclub.model;

public class FeeType {

	private Integer id;

	private String feetype;

	private Double price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFeetype() {
		return feetype;
	}

	public void setFeetype(String feetype) {
		this.feetype = feetype == null ? null : feetype.trim();
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	
	
	}

	@Override
	public String toString() {
		return "FeeType [id=" + id + ", feetype=" + feetype + ", price="
				+ price + ", getId()=" + getId() + ", getFeetype()="
				+ getFeetype() + ", getPrice()=" + getPrice() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}