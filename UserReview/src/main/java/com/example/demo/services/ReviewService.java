package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import com.example.demo.exceptions.ReviewException;
import com.example.demo.models.Review;

public interface ReviewService {

//    Review createReview(Review review);
//
//    void deleteReview(Long id);
	
	    Review createReviewForProduct(Long productId, Review review) throws ReviewException;

	    void deleteReviewForProduct(Long productId, Long reviewId) throws ReviewException;
}
