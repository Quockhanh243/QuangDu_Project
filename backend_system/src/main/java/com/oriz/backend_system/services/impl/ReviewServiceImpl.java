package com.oriz.backend_system.services.impl;

import com.oriz.backend_system.model.Review;
import com.oriz.backend_system.repositories.ReviewRepository;
import com.oriz.backend_system.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Override
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    @Override
    public Review addReview(Review review) {
        // You can perform any business logic/validation before saving
        review.setCreatedAt(LocalDateTime.now());
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Long id, Review review) {
        // Check if the review already exists in the database
        Optional<Review> existingReview = reviewRepository.findById(id);
        if (existingReview.isPresent()) {
            Review updatedReview = existingReview.get();
            updatedReview.setReview(review.getReview());
            // Set other properties as needed
            return reviewRepository.save(updatedReview);
        }
        return null; // Review ID is missing or not found
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    // Implement methods for Review-related operations
}
