package com.example.demo.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Product;
import com.example.demo.models.Review;

public interface ReviewDao extends JpaRepository<Review, Long>{

	Optional<Review> findByIdAndProduct(Long reviewId, Product product);

}
