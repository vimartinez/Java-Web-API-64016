package com.educacionit.service;

import com.educacionit.dao.UserDao;
import com.educacionit.model.User;

public class UserService {
	
	UserDao userDao = new UserDao();

	public User getUserById(Long id) {
		return userDao.getById(id);
	}

}
