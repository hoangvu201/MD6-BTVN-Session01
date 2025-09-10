package ra.btvn01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.btvn01.entity.Product;
import ra.btvn01.response.ApiDataResponse;
import ra.btvn01.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<ApiDataResponse<List<Product>>> getAll() {
        return new ResponseEntity<>(
                new ApiDataResponse<>(
                        true,
                        "Get products successfully!",
                        productService.getAllProducts(),
                        null,
                        HttpStatus.OK
                ),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Product>> getById(@PathVariable Long id) {
        return productService.getProductById(id)
                .map(product -> new ResponseEntity<>(
                        new ApiDataResponse<>(
                                true,
                                "Get product successfully!",
                                product,
                                null,
                                HttpStatus.OK
                        ),
                        HttpStatus.OK
                ))
                .orElse(new ResponseEntity<>(
                        new ApiDataResponse<>(
                                false,
                                "Product not found",
                                null,
                                "Product with id " + id + " not found",
                                HttpStatus.NOT_FOUND
                        ),
                        HttpStatus.NOT_FOUND
                ));
    }

    @PostMapping
    public ResponseEntity<ApiDataResponse<Product>> create(@RequestBody Product product) {
        Product saved = productService.createProduct(product);
        return new ResponseEntity<>(
                new ApiDataResponse<>(
                        true,
                        "Product created successfully!",
                        saved,
                        null,
                        HttpStatus.CREATED
                ),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Product>> update(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product)
                .map(updated -> new ResponseEntity<>(
                        new ApiDataResponse<>(
                                true,
                                "Product updated successfully!",
                                updated,
                                null,
                                HttpStatus.OK
                        ),
                        HttpStatus.OK
                ))
                .orElse(new ResponseEntity<>(
                        new ApiDataResponse<>(
                                false,
                                "Product not found",
                                null,
                                "Product with id " + id + " not found",
                                HttpStatus.NOT_FOUND
                        ),
                        HttpStatus.NOT_FOUND
                ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiDataResponse<Void>> delete(@PathVariable Long id) {
        if (productService.deleteProduct(id)) {
            return new ResponseEntity<>(
                    new ApiDataResponse<>(
                            true,
                            "Product deleted successfully!",
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
                        "Product not found",
                        null,
                        "Product with id " + id + " not found",
                        HttpStatus.NOT_FOUND
                ),
                HttpStatus.NOT_FOUND
        );
    }
}

