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
		Boolean resultado = false;
		try {
			if (psAdd==null) {
				psAdd = conectarDB().prepareStatement(add);
			}
			psAdd.setLong(1, t.getId());
			psAdd.setString(2, t.getName());
			psAdd.setLong(3, t.getId_country());

			if (psAdd.executeUpdate()==1) resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Boolean del(State t) {
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
	public Boolean upd(State t) {
		Boolean resultado = false;
		try {
			if (psUpd==null) {
				psUpd = conectarDB().prepareStatement(upd);
			}
			psUpd.setString(1, t.getName());
			psAdd.setLong(2, t.getId_country());
			psUpd.setLong(3, t.getId());
			if (psUpd.executeUpdate()==1) resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public State getById(Long id) {
		State StateAux = null;
		try {
			if (psGetById==null) {
				psGetById = conectarDB().prepareStatement(getById);
			}
			psGetById.setLong(1, id);
			ResultSet resultado = psGetById.executeQuery();
			if(resultado.next()) {
				StateAux = new State();
				StateAux.setId(resultado.getLong("id"));
				StateAux.setName(resultado.getString("name"));
				StateAux.setId_country(resultado.getLong("id_country"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return StateAux;
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
