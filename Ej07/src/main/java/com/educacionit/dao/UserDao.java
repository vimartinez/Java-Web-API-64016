package com.educacionit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.educacionit.conf.MySQLConnection;
import com.educacionit.model.User;

public class UserDao implements Dao<User, Long>, MySQLConnection {
	
	private PreparedStatement psGetUserById = null;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean add(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean del(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean upd(User t) {
		// TODO Auto-generated method stub
		return null;
	}

}
