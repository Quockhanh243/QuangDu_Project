package com.oriz.backend_system.services;

import com.oriz.backend_system.model.Category;

public interface CategoryService {
    Category getCategoryById(Long id);

    Category addCategory(Category category);

    Category updateCategory(Long id, Category category);

    void deleteCategory(Long id);

    // Add methods for Category-related operations
}
