package com.oriz.backend_system.services;

import com.oriz.backend_system.model.Review;

public interface ReviewService {
    Review getReviewById(Long id);

    Review addReview(Review review);

    Review updateReview(Long id, Review review);

    void deleteReview(Long id);
}
