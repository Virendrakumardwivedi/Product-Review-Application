package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ReviewException;
import com.example.demo.models.Product;
import com.example.demo.models.Review;
import com.example.demo.repositorys.ProductDao;
import com.example.demo.repositorys.ReviewDao;

@Service
public class ReviewImpl implements ReviewService{
	
	@Autowired
	private ReviewDao reviewDao;
	@Autowired
	private ProductDao productDao;
	

	@Override
	public Review createReviewForProduct(Long productId, Review review)throws ReviewException {
		
        Optional<Product> productOptional = productDao.findById(productId);
        if (productOptional.isEmpty()) {
            throw new ReviewException("Product not found with ID: " + productId);
        }

        // Associate the review with the product and save it
        Product product = productOptional.get();
        review.setProduct(product);
        Review savedReview = reviewDao.save(review);
        return savedReview;
	}

	@Override
	public void deleteReviewForProduct(Long productId, Long reviewId) throws ReviewException {
		
		 Optional<Product> productOptional = productDao.findById(productId);
	        if (productOptional.isEmpty()) {
	            throw new ReviewException("Product not found with ID: " + productId);
	        }

	        Product product = productOptional.get();

	        // Check if the review with the given ID exists for the specified product
	        Optional<Review> reviewOptional = reviewDao.findByIdAndProduct(reviewId, product);
	        if (reviewOptional.isEmpty()) {
	            throw new ReviewException("Review not found for Product with ID: " + productId + " and Review ID: " + reviewId);
	        }

	        reviewDao.delete(reviewOptional.get());
		
	}

}
