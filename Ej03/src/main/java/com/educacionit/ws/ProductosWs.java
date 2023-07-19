package com.educacionit.ws;

import java.util.List;

import com.educacionit.model.Product;

public interface ProductosWs {
	
	public Product getProductById(long productId);
	
	public Boolean addProduct(Product producto);
	
	public Boolean updProduct(Product producto);
	
	public Boolean delProduct(Product producto);
	
	public List<Product> getAllProducts();

}
