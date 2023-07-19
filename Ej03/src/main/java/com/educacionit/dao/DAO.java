package com.educacionit.dao;

import java.util.List;

public interface DAO<Producto, Long> {
	
	Boolean add(Producto producto);
	
	Boolean del(Producto producto);
	
	Boolean upd(Producto producto);
	
	Producto getById(Long id);
	
	List<Producto> getAll();

}
