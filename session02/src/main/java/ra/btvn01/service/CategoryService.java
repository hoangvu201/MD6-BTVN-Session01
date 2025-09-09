package ra.btvn01.service;


import ra.btvn01.entity.Category;

import java.util.List;

import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategories();

    Optional<Category> getCategoryById(Long id);

    Category createCategory(Category category);

    Optional<Category> updateCategory(Long id, Category categoryDetails);

    boolean deleteCategory(Long id);
}