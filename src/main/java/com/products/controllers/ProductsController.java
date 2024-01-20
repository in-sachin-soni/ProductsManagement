package com.products.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.products.models.Product;
import com.products.service.ProductServiceImpl;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/admin/products")
public class ProductsController {
	
	@Autowired
	private ProductServiceImpl prodService;
	
	@PostMapping("/save")
	public ResponseEntity<Product> saveProducts(@RequestBody Product product) {
		return new ResponseEntity<Product>(prodService.saveProduct(product), HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> updateProducts(@RequestBody Product product, @PathVariable(name="id") int productId) {	
		return new ResponseEntity<Product>(prodService.updateProduct(productId,product),HttpStatus.OK);
	}
	
	@GetMapping("/list")
	public List<Product> getProducts() {
		return prodService.getProducts();
	}

	@DeleteMapping("/delete/{id}")
	public int deleteProducts(@PathVariable(name = "id") int productId) {
		prodService.deleteProduct(productId);
		return productId;
	}

}
