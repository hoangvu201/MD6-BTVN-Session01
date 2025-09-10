package ra.btvn01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.btvn01.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategoryId(Long categoryId);

    List<Product> findByNameContainingIgnoreCase(String keyword);
}
