package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.exceptions.ProductException;
import com.example.demo.models.Product;
import com.example.demo.repositorys.ProductDao;





@Service
public class ProductImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;
	

	@Override
	public List<Product> getAllProducts() throws ProductException {
		List<Product> list = productDao.findAll();
		if(list.size()==0) {
			throw new ProductException("Products is not present..!");
			
		}
		return list;
	}

	@Override
	public Product getProductById(Long id) throws ProductException {
		
		Optional<Product> opt = productDao.findById(id);
		if(opt.isPresent()) {
			Product p= opt.get();
			return p;
		}else {
			throw new ProductException("Product not exist in this id "+id);
		}
	}

	@Override
	public Product createProduct(Product product) {
		return  productDao.save(product);
	}

	@Override
	public Product updateProduct(Long id, Product product) throws ProductException {
		
		Optional<Product> opt = productDao.findById(product.getId());

		if (opt.isPresent()) {
			Product productUpdate= productDao.save(product);
			return productUpdate;
		}
		

		throw new ProductException("user detail Error.");
	}

	@Override
	public String deleteProduct(Long id) throws ProductException {
		String message= " Product not found";
		Optional<Product> opt = productDao.findById(id);
		
		if(opt.isPresent()) {
			Product pro = opt.get();
			productDao.delete(pro);
			message = "Product deleted";
			
		}else {
			throw new ProductException("user not exixt");
		}
		return message;
	}
		
	

}
