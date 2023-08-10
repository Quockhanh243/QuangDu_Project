package com.oriz.backend_system.services;

import com.oriz.backend_system.model.Rating;

public interface RatingService {
    Rating getRatingById(Long id);

    Rating addRating(Rating rating);

    Rating updateRating(Long id, Rating rating);

    void deleteRating(Long id);

    // Add methods for Rating-related operations
}
