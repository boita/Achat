package com.example.game.model;

public class Product {
	private long id;
	private String name;
	private int category_id;
	
	public Product(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	protected long getId() {
		return id;
	}
	protected void setId(long id) {
		this.id = id;
	}
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected int getCategory_id() {
		return category_id;
	}
	protected void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	
	
}
