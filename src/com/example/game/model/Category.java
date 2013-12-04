package com.example.game.model;

public class Category {
	
	private int id;
	private String name;
	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	protected int getId() {
		return id;
	}
	protected void setId(int id) {
		this.id = id;
	}
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	
	
	
}
