package com.educacionit.model;

public class City {
	
	private Long id;
	private String name;
	private Long id_state;
	
	public City() {
		
	}

	public City(Long id, String name, Long id_state) {
		super();
		this.id = id;
		this.name = name;
		this.id_state = id_state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId_state() {
		return id_state;
	}

	public void setId_state(Long id_state) {
		this.id_state = id_state;
	}
	
	

}
