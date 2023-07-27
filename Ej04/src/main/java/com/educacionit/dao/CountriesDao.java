package com.educacionit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.educacionit.model.Country;

public class CountriesDao implements DAO<Country, Long>, MySQLConnection {

	private String getAll = "SELECT id, name FROM countries";
	private String getById = "SELECT id, name FROM countries WHERE id = ?";
	private String delById = "DELETE FROM countries WHERE id=?";
	private String upd = "UPDATE countries SET name=? WHERE id=?";
	private String add = "INSERT INTO countries (id, name) VALUES(?,?)";

	private PreparedStatement psGetAll;
	private PreparedStatement psGetById;
	private PreparedStatement psDelById;
	private PreparedStatement psUpd;
	private PreparedStatement psAdd;

	@Override
	public Boolean add(Country t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean del(Country t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean upd(Country t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Country getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Country> getAll() {
		List<Country> listCountries = new ArrayList<Country>();

		try {
			if (psGetAll == null) {
				psGetAll = conectarDB().prepareStatement(getAll);
			}
			
			ResultSet resultado = psGetAll.executeQuery();
			while(resultado.next()) {
				Country countryAux = new Country();
				countryAux.setId(resultado.getLong("id"));
				countryAux.setName(resultado.getString("name"));
				listCountries.add(countryAux);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCountries;
	}

}
