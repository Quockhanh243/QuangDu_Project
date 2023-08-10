package com.oriz.backend_system.services.impl;

import com.oriz.backend_system.model.Product;
import com.oriz.backend_system.repositories.ProductRepository;
import com.oriz.backend_system.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    public Product addProduct(Product product) {
        // You can perform any business logic/validation before saving
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Optional<Product> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product updatedProduct = existingProduct.get();
            updatedProduct.setTitle(product.getTitle());
            updatedProduct.setDescription(product.getDescription());
            updatedProduct.setPrice(product.getPrice());
            updatedProduct.setDiscountedPrice(product.getDiscountedPrice());
            updatedProduct.setDiscountPercent(product.getDiscountPercent());
            updatedProduct.setQuantity(product.getQuantity());
            updatedProduct.setBrand(product.getBrand());
            updatedProduct.setColor(product.getColor());
            updatedProduct.setImageUrl(product.getImageUrl());
            // Set other properties as needed
            return productRepository.save(updatedProduct);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public int getTotalProductQuantity() {
        // Implement logic to calculate total product quantity
        // This might involve summing the quantities of all products
        // in the repository or performing a specific query
        return 0; // Placeholder value
    }
}
