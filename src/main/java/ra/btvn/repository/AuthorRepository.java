package ra.btvn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.btvn.model.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
