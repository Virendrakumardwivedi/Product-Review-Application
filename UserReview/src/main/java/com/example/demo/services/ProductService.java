package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.exceptions.ProductException;
import com.example.demo.models.Product;

public interface ProductService {

    List<Product> getAllProducts() throws ProductException;

    public Product getProductById(Long id) throws ProductException;

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product) throws ProductException;

    String deleteProduct(Long id) throws ProductException;
}
