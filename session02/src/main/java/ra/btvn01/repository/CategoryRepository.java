package ra.btvn01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.btvn01.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}