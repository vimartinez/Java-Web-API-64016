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
	private String getById = "SELECT id, nombre, descripcion, precio FROM productos WHERE id= ?;";
	private String updProduct = "UPDATE productos SET nombre=?, descripcion=?, precio=? WHERE id=?;";
	private PreparedStatement ps = null;
	private PreparedStatement psGet;

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
		Boolean resultado = false;
		
		try {
			ps = conectarDB().prepareStatement(updProduct);
			ps.setString(1, producto.getNombre());
			ps.setString(2, producto.getDescripcion());
			ps.setFloat(3, producto.getPrecio());
			ps.setLong(4, producto.getId());
			if(ps.executeUpdate()==1) resultado = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return resultado;
	}

	@Override
	public Product getById(Long id) {
		Product productoAux = null;
		
		try {
			ps = conectarDB().prepareStatement(getById);
			ps.setLong(1, id);
			ResultSet resultado = ps.executeQuery();
			if(resultado.next()) {
				productoAux = new Product();
				productoAux.setId(resultado.getLong("id"));
				productoAux.setNombre(resultado.getNString("nombre"));
				productoAux.setDescripcion(resultado.getString("descripcion"));
				productoAux.setPrecio(resultado.getFloat("precio"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productoAux;
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
	
	public Product getById2(Long id) {
		Product productoAux = null;
		Long inicio, tiempo;
		inicio = System.currentTimeMillis();
		
		try {
			if (psGet == null) {
				psGet = conectarDB().prepareStatement(getById);
			}
			
			psGet.setLong(1, id);
			ResultSet resultado = psGet.executeQuery();
			if(resultado.next()) {
				productoAux = new Product();
				productoAux.setId(resultado.getLong("id"));
				productoAux.setNombre(resultado.getNString("nombre"));
				productoAux.setDescripcion(resultado.getString("descripcion"));
				productoAux.setPrecio(resultado.getFloat("precio"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tiempo = System.currentTimeMillis() - inicio;
		System.out.println("tiempo de ejecucion " + tiempo.toString());
		return productoAux;
	}

}
