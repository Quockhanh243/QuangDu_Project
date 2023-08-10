package com.oriz.backend_system.services.impl;

import com.oriz.backend_system.model.Image;
import com.oriz.backend_system.repositories.ImageRepository;
import com.oriz.backend_system.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Override
    public Image getImageById(Long id) {
        return imageRepository.findById(id).orElse(null);
    }

    @Override
    public Image addImage(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public Image updateImage(Long id, Image image) {
        Optional<Image> existingImage = imageRepository.findById(id);
        if (existingImage.isPresent()) {
            Image updatedImage = existingImage.get();
            updatedImage.setImageUrl(image.getImageUrl());
            updatedImage.setProduct(image.getProduct());
            // Set other properties as needed
            return imageRepository.save(updatedImage);
        }
        return null; // Image ID is missing or not found
    }

    @Override
    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }

    // Implement methods for Image-related operations
}
