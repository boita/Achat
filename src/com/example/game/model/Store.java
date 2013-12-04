package com.example.game.model;

public class Store {
	
	private long id;
	private String name;
	private long category_id;
	public Store(long id, String name) {
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
	protected long getCategory_id() {
		return category_id;
	}
	protected void setCategory_id(long category_id) {
		this.category_id = category_id;
	}
	
	
	
}
