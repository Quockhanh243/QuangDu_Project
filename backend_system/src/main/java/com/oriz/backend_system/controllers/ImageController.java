package com.oriz.backend_system.controllers;

import com.oriz.backend_system.model.Image;
import com.oriz.backend_system.services.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/{id}")
    public ResponseEntity<Image> getImageById(@PathVariable Long id) {
        Image image = imageService.getImageById(id);
        if (image != null) {
            return ResponseEntity.ok(image);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Image> addImage(@RequestBody Image image) {
        Image addedImage = imageService.addImage(image);
        return ResponseEntity.ok(addedImage);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Image> updateImage(@PathVariable Long id, @RequestBody Image image) {
        Image updatedImage = imageService.updateImage(id, image);
        if (updatedImage != null) {
            return ResponseEntity.ok(updatedImage);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }
}
