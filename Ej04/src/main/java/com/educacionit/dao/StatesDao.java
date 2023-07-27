package com.educacionit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.educacionit.model.Country;
import com.educacionit.model.State;

public class StatesDao implements DAO<State, Long>, MySQLConnection {
	
	private String getAll = "SELECT id, name, id_country FROM states";
	private String getById = "SELECT id, name, id_country FROM states WHERE id = ?";
	private String delById = "DELETE FROM states WHERE id=?";
	private String upd = "UPDATE states SET name=?, id_country WHERE id=?";
	private String add = "INSERT INTO states (id, name, id_country) VALUES(?,?,?)";

	private PreparedStatement psGetAll;
	private PreparedStatement psGetById;
	private PreparedStatement psDelById;
	private PreparedStatement psUpd;
	private PreparedStatement psAdd;

	@Override
	public Boolean add(State t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean del(State t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean upd(State t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public State getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<State> getAll() {
		List<State> listStates = new ArrayList<State>();

		try {
			if (psGetAll == null) {
				psGetAll = conectarDB().prepareStatement(getAll);
			}
			
			ResultSet resultado = psGetAll.executeQuery();
			while(resultado.next()) {
				State stateAux = new State();
				stateAux.setId(resultado.getLong("id"));
				stateAux.setName(resultado.getString("name"));
				stateAux.setId_country(resultado.getLong("id_country"));
				listStates.add(stateAux);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listStates;
	}

}
