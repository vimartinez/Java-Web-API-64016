package com.educacionit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.educacionit.model.Product;

public class ProductosDAO implements DAO<Product, Long>, MySQLConnection {
	
	private String getAllProducts = "SELECT id, nombre, descripcion, precio FROM productos";
	private String addProduct = "INSERT INTO productos (ID, nombre, descripcion, precio) VALUES(?, ?, ?, ?)";
	private String delProduct = "DELETE FROM productos WHERE id = ?";
	private PreparedStatement ps = null;

	@Override
	public Boolean add(Product producto) {
		Boolean resultado = false;
		try {
			ps = conectarDB().prepareStatement(addProduct);
			ps.setLong(1, producto.getId());
			ps.setString(2, producto.getNombre());
			ps.setString(3, producto.getDescripcion());
			ps.setFloat(4, producto.getPrecio());
			
			if(ps.executeUpdate()==1) resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Boolean del(Product producto) {
		Boolean resultado = false;
		
		try {
			ps = conectarDB().prepareStatement(delProduct);
			ps.setLong(1, producto.getId());
			if(ps.executeUpdate()==1) resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public Boolean upd(Product producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getAll() {
		List<Product> listadoProductos = new ArrayList<Product>();
		try {
			ps = conectarDB().prepareStatement(getAllProducts);
			ResultSet resultadoQuery = ps.executeQuery();
			while(resultadoQuery.next()) {
				Product productAux = new Product();
				productAux.setId(resultadoQuery.getLong("id"));
				productAux.setNombre(resultadoQuery.getString("nombre"));
				productAux.setDescripcion(resultadoQuery.getString("descripcion"));
				productAux.setPrecio(resultadoQuery.getFloat("precio"));
				listadoProductos.add(productAux);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listadoProductos;
	}

}
