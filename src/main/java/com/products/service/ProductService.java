package com.products.service;

import java.util.List;

import com.products.models.Product;

public interface ProductService {
	
	public Product saveProduct(Product product);
	public void deleteProduct(int id);
	public List<Product> getProducts();
	

}
