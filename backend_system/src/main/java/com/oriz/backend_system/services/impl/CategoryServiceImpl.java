package com.oriz.backend_system.services.impl;

import com.oriz.backend_system.model.Category;
import com.oriz.backend_system.repositories.CategoryRepository;
import com.oriz.backend_system.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Optional<Category> existingCategory = categoryRepository.findById(id);
        if (existingCategory.isPresent()) {
            Category updatedCategory = existingCategory.get();
            updatedCategory.setName(category.getName());
            updatedCategory.setParentCategory(category.getParentCategory());
            updatedCategory.setLevel(category.getLevel());
            // Set other properties as needed
            return categoryRepository.save(updatedCategory);
        }
        return null; // Category ID is missing or not found
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    // Implement methods for Category-related operations
}
