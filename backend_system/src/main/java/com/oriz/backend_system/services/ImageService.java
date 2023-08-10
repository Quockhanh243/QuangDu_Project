package com.oriz.backend_system.services;

import com.oriz.backend_system.model.Image;

public interface ImageService {
    Image getImageById(Long id);

    Image addImage(Image image);

    Image updateImage(Long id, Image image);

    void deleteImage(Long id);

    // Add methods for Image-related operations
}
