package com.educacionit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.educacionit.conf.MySQLConnection;
import com.educacionit.model.User;

public class UserDao implements Dao<User, Long>, MySQLConnection {
	
	private PreparedStatement psGetUserById = null;
	private PreparedStatement psGetAll = null;
	private PreparedStatement psAdd = null;
	private PreparedStatement psDel = null;
	private PreparedStatement psUpd = null;

	@Override
	public User getById(Long id) {
		User user = null;
		try {
			psGetUserById = conectarDB().prepareStatement(
					"SELECT Id, nombreApellido, mail, mailVerificado, clave, Direccion, fechaNacimiento"
					+ " FROM Users "
					+ "WHERE Id=?;"	);
			psGetUserById.setLong(1, id);
			ResultSet resultado = psGetUserById.executeQuery();
			if(resultado.next()) {
				user = new User();
				user.setNombreApellido(resultado.getString("nombreApellido"));
				user.setMail(resultado.getString("mail"));
				user.setId(resultado.getLong("id"));
				user.setDireccion(resultado.getString("Direccion"));
				user.setClave(resultado.getString("clave"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> getAll() {
		List<User> usersList = new ArrayList<>();
		if(psGetAll == null) {
			try {
				psGetAll = conectarDB().prepareStatement(
						"SELECT Id, nombreApellido, mail, mailVerificado, clave, Direccion, fechaNacimiento FROM Users ");
				ResultSet resultado  = psGetAll.executeQuery();
				while(resultado.next()) {
					User userAux = new User();
					userAux.setNombreApellido(resultado.getString("nombreApellido"));
					userAux.setMail(resultado.getString("mail"));
					userAux.setId(resultado.getLong("id"));
					userAux.setDireccion(resultado.getString("Direccion"));
					userAux.setClave(resultado.getString("clave"));
					usersList.add(userAux);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return usersList;
	}

	@Override
	public Boolean add(User user) {
		Boolean resultado = false;
		if(psAdd == null) {
			try {
				psAdd = conectarDB().prepareStatement("INSERT INTO Users (Id, nombreApellido, mail, mailVerificado, clave, Direccion) "
						+ "VALUES(?,?,?,?,MD5(?),?)");
				psAdd.setLong(1, user.getId());
				psAdd.setString(2, user.getNombreApellido());
				psAdd.setString(3, user.getMail());
				psAdd.setInt(4, 0);
				psAdd.setString(5, user.getClave());
				psAdd.setString(6, user.getDireccion());
				if (psAdd.executeUpdate()==1) resultado = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultado;
	}

	@Override
	public Boolean del(User user) {
		Boolean resultado = false;
		if(psDel == null) {
			try {
				psDel = conectarDB().prepareStatement("DELETE FROM Users WHERE id = ?");
				psDel.setLong(1, user.getId());
				if (psDel.executeUpdate()==1) resultado = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultado;
	}

	@Override
	public Boolean upd(User user) {
		Boolean resultado = false;
		if(psUpd == null) {
			try {
				psUpd = conectarDB().prepareStatement("UPDATE Users set nombreApellido=?, mail=?, clave=MD5(?), Direccion=? WHERE id = ? ");
				psUpd.setString(1, user.getNombreApellido());
				psUpd.setString(2, user.getMail());
				psUpd.setString(3, user.getClave());
				psUpd.setString(4, user.getDireccion());
				psUpd.setLong(5, user.getId());
				if (psUpd.executeUpdate()==1) resultado = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultado;
	}

}
