package com.oriz.backend_system.services.impl;

import com.oriz.backend_system.model.Rating;
import com.oriz.backend_system.repositories.RatingRepository;
import com.oriz.backend_system.services.RatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    private final RatingRepository ratingRepository;

    @Override
    public Rating getRatingById(Long id) {
        return ratingRepository.findById(id).orElse(null);
    }

    @Override
    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Rating updateRating(Long id, Rating rating) {
        Optional<Rating> existingRating = ratingRepository.findById(id);
        if (existingRating.isPresent()) {
            Rating updatedRating = existingRating.get();
            updatedRating.setCustomer(rating.getCustomer());
            updatedRating.setProduct(rating.getProduct());
            updatedRating.setRating(rating.getRating());
            // Set other properties as needed
            return ratingRepository.save(updatedRating);
        }
        return null; // Rating ID is missing or not found
    }

    @Override
    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }

    // Implement methods for Rating-related operations
}
