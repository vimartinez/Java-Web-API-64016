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
		Boolean resultado = false;
		try {
			if (psAdd==null) {
				psAdd = conectarDB().prepareStatement(add);
			}
			psAdd.setLong(1, t.getId());
			psAdd.setString(2, t.getName());

			if (psAdd.executeUpdate()==1) resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Boolean del(Country t) {
		Boolean resultado = false;
		try {
			if (psDelById==null) {
				psDelById = conectarDB().prepareStatement(delById);
			}
			
			psDelById.setLong(1, t.getId());;
			if (psDelById.executeUpdate()==1) resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Boolean upd(Country t) {
		Boolean resultado = false;
		try {
			if (psUpd==null) {
				psUpd = conectarDB().prepareStatement(upd);
			}
			psUpd.setString(1, t.getName());
			psUpd.setLong(2, t.getId());
			if (psUpd.executeUpdate()==1) resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Country getById(Long id) {
		Country CountryAux = null;
		try {
			if (psGetById==null) {
				psGetById = conectarDB().prepareStatement(getById);
			}
			psGetById.setLong(1, id);
			ResultSet resultado = psGetById.executeQuery();
			if(resultado.next()) {
				CountryAux = new Country();
				CountryAux.setId(resultado.getLong("id"));
				CountryAux.setName(resultado.getString("name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return CountryAux;
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
