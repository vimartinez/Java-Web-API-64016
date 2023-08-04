package com.educacionit.conf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface MySQLConnection {
	
	default Connection conectarDB() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conexion = null;
		String url = "jdbc:mysql://localhost:3306/jwa-ej07";
		String usr = "root";
		String pass = "1234";
		
		try {
			conexion = DriverManager.getConnection(url, usr, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conexion;
		
	}

}
