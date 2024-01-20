package com.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.products.models.Product;
import com.products.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;
	
	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepo.save(product);
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return productRepo.findAll();
	}
	
	public Product updateProduct(int productId, Product product) {
		Product productObj = productRepo.findById(productId).get();
		productObj.setName(product.getName());
		productObj.setPrice(product.getPrice());
		return productRepo.save(productObj);
	}
	
	@Override
	public void deleteProduct(int id) {
		productRepo.deleteById(id);
	}

}
