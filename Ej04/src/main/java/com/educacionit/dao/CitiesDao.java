package com.educacionit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.educacionit.model.City;

public class CitiesDao implements DAO<City, Long>, MySQLConnection {

	private String getAll = "SELECT id, name FROM cities;";
	private String getById = "SELECT id, name, id_state FROM cities WHERE id = ?;";
	private String delById = "DELETE FROM cities WHERE id = ?";
	private String upd = "UPDATE cities SET name=?  WHERE id=?;";
	private String add = "INSERT INTO cities (id, name) VALUES(?, ?);";
	
	private PreparedStatement psGetAll = null;
	private PreparedStatement psGetById = null;
	private PreparedStatement psUpd = null;
	private PreparedStatement psadd = null;
	private PreparedStatement psdelById = null;

	@Override
	public Boolean add(City t) {
		Boolean resultado = false;
		try {
			if (psadd==null) {
				psadd = conectarDB().prepareStatement(add);
			}
			psadd.setLong(1, t.getId());
			psadd.setString(2, t.getName());

			if (psadd.executeUpdate()==1) resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Boolean del(City t) {
		Boolean resultado = false;
		try {
			if (psdelById==null) {
				psdelById = conectarDB().prepareStatement(delById);
			}
			
			psdelById.setLong(1, t.getId());;
			if (psdelById.executeUpdate()==1) resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Boolean upd(City t) {
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
	public City getById(Long id) {
		City CityAux = null;
		try {
			if (psGetById==null) {
				psGetById = conectarDB().prepareStatement(getById);
			}
			psGetById.setLong(1, id);
			ResultSet resultado = psGetById.executeQuery();
			if(resultado.next()) {
				CityAux = new City();
				CityAux.setId(resultado.getLong("id"));
				CityAux.setId_state(resultado.getLong("id_state"));
				CityAux.setName(resultado.getString("name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return CityAux;
	}

	@Override
	public List<City> getAll() {
		List<City> listCountries = new ArrayList<City>();
		try {
			if (psGetAll==null) {
				psGetAll = conectarDB().prepareStatement(getAll);
			}
						
			ResultSet resultado = psGetAll.executeQuery();
			while(resultado.next()) {
				City CityAux = new City();
				CityAux.setId(resultado.getLong("id"));
				CityAux.setName(resultado.getString("name"));
				listCountries.add(CityAux);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCountries;
	}

}
