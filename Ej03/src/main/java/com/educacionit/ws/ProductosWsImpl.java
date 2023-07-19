package com.educacionit.ws;

import java.util.List;

import com.educacionit.dao.ProductosDAO;
import com.educacionit.model.Product;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public class ProductosWsImpl implements ProductosWs {

	ProductosDAO productosDao = new ProductosDAO();
	
	@Override
	@WebMethod
	public Product getProductById(long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod
	public Boolean addProduct(Product producto) {
		return productosDao.add(producto);
	}

	@Override
	@WebMethod
	public Boolean updProduct(Product producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@WebMethod
	public Boolean delProduct(Product producto) {
		return productosDao.del(producto);
	}

	@Override
	@WebMethod
	public List<Product> getAllProducts() {
		return productosDao.getAll();
	}

}
