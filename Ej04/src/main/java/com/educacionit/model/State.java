package com.educacionit.model;

public class State {
	
	private Long id;
	private String name;
	private Long id_country;
	
	public State() {
		
	}

	public State(Long id, String name, Long id_country) {
		super();
		this.id = id;
		this.name = name;
		this.id_country = id_country;
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

	public Long getId_country() {
		return id_country;
	}

	public void setId_country(Long id_country) {
		this.id_country = id_country;
	}



}
