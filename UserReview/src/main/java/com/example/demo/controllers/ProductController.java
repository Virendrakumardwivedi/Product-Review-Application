package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.demo.exceptions.ProductException;
import com.example.demo.models.Product;
import com.example.demo.services.ProductService;






@Controller
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductService proService;
	
	
	
	@PostMapping("/products")
	public ResponseEntity<Product> registerProducts(@RequestBody Product product)throws ProductException{
		Product addProducts = proService.createProduct(product);
		return new ResponseEntity<Product>(addProducts,HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() throws ProductException{
		
		List<Product> products = proService.getAllProducts();
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> findProductById(@PathVariable("id")Long id)throws ProductException{
		Product pro = proService.getProductById(id);
	
		return new ResponseEntity<Product>(pro,HttpStatus.OK);
	}
	
	
	 @PutMapping("/products/{id}")
	    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) throws ProductException {
			Product produc = proService.updateProduct(id, product);
			
			return new ResponseEntity<Product>(produc,HttpStatus.ACCEPTED);
			
	    }
	 
	 @DeleteMapping("/products/{id}")
		public ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) throws  ProductException{
			String product = proService.deleteProduct(id);
			
			return new ResponseEntity<String>(product,HttpStatus.OK);
		}
	
	

}
