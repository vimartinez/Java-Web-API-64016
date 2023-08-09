package com.educacionit.service;

import java.util.List;

import com.educacionit.dao.UserDao;
import com.educacionit.model.User;

public class UserService {
	
	UserDao userDao = new UserDao();

	public User getUserById(Long id) {
		return userDao.getById(id);
	}

	public List<User> getAllUsers() {
		return userDao.getAll();
	}

	public Boolean addUser(User user) {
		return userDao.add(user);
	}

	public boolean delUser(User user) {
		return userDao.del(user);
	}

	public boolean updUser(User user) {
		
		User userAux = getUserById(user.getId());
		if (userAux != null) {
			if(user.getNombreApellido() != "") userAux.setNombreApellido(user.getNombreApellido());
			if(user.getClave() != "") userAux.setClave(user.getClave());
			if(user.getDireccion() != "") userAux.setDireccion(user.getDireccion());
			if(user.getMail() != "") userAux.setMail(user.getMail());
			return userDao.upd(userAux);
		}
		else {
			return false;
		}
	}

}
