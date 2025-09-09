package ra.btvn01.service;

import ra.btvn01.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);

    Product createProduct(Product product);

    Optional<Product> updateProduct(Long id, Product productDetails);

    boolean deleteProduct(Long id);

    List<Product> getProductsByCategory(Long categoryId);

    List<Product> searchProductsByName(String keyword);

}
