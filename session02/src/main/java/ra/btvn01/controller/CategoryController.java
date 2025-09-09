package ra.btvn01.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.btvn01.entity.Category;
import ra.btvn01.response.ApiDataResponse;
import ra.btvn01.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<ApiDataResponse<List<Category>>> getAll() {
        return new ResponseEntity<>(
                new ApiDataResponse<>(
                        true,
                        "Get categories successfully!",
                        categoryService.getAllCategories(),
                        null,
                        HttpStatus.OK
                ),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Category>> getById(@PathVariable Long id) {
        return categoryService.getCategoryById(id)
                .map(category -> new ResponseEntity<>(
                        new ApiDataResponse<>(
                                true,
                                "Get category successfully!",
                                category,
                                null,
                                HttpStatus.OK
                        ),
                        HttpStatus.OK
                ))
                .orElse(new ResponseEntity<>(
                        new ApiDataResponse<>(
                                false,
                                "Category not found",
                                null,
                                "Category with id " + id + " not found",
                                HttpStatus.NOT_FOUND
                        ),
                        HttpStatus.NOT_FOUND
                ));
    }

    @PostMapping
    public ResponseEntity<ApiDataResponse<Category>> create(@RequestBody Category category) {
        Category saved = categoryService.createCategory(category);
        return new ResponseEntity<>(
                new ApiDataResponse<>(
                        true,
                        "Category created successfully!",
                        saved,
                        null,
                        HttpStatus.CREATED
                ),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Category>> update(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category)
                .map(updated -> new ResponseEntity<>(
                        new ApiDataResponse<>(
                                true,
                                "Category updated successfully!",
                                updated,
                                null,
                                HttpStatus.OK
                        ),
                        HttpStatus.OK
                ))
                .orElse(new ResponseEntity<>(
                        new ApiDataResponse<>(
                                false,
                                "Category not found",
                                null,
                                "Category with id " + id + " not found",
                                HttpStatus.NOT_FOUND
                        ),
                        HttpStatus.NOT_FOUND
                ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Void>> delete(@PathVariable Long id) {
        if (categoryService.deleteCategory(id)) {
            return new ResponseEntity<>(
                    new ApiDataResponse<>(
                            true,
                            "Category deleted successfully!",
                            null,
                            null,
                            HttpStatus.NO_CONTENT
                    ),
                    HttpStatus.NO_CONTENT
            );
        }
        return new ResponseEntity<>(
                new ApiDataResponse<>(
                        false,
                        "Category not found",
                        null,
                        "Category with id " + id + " not found",
                        HttpStatus.NOT_FOUND
                ),
                HttpStatus.NOT_FOUND
        );
    }
}