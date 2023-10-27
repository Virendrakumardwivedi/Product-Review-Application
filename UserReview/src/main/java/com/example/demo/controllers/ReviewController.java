package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.exceptions.ReviewException;
import com.example.demo.models.Review;
import com.example.demo.services.ProductService;
import com.example.demo.services.ReviewService;

@Controller
@RequestMapping("/api/products")
public class ReviewController {
	
	@Autowired
	private ReviewService revService;
	@Autowired
	private ProductService proService;

	@PostMapping("/{productId}/reviews")
	 public ResponseEntity<Review> createReviewForProduct(@PathVariable Long productId, @RequestBody Review review) {
	        try {
	            Review createdReview = revService.createReviewForProduct(productId, review);
	            return ResponseEntity.status(HttpStatus.CREATED).body(createdReview);
	        } catch (ReviewException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // Return an empty response with 404 status
	        }
	    }
	 
	 
	 @DeleteMapping("/{productId}/reviews/{reviewId}")
	    public ResponseEntity<String> deleteReviewForProduct(@PathVariable Long productId, @PathVariable Long reviewId) {
	        try {
	            revService.deleteReviewForProduct(productId, reviewId);
	            return ResponseEntity.status(HttpStatus.OK).body(null); 
	        } catch (ReviewException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	        }
	    }

	
	
}
