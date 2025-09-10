package ra.btvn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.btvn.model.entity.Borrow;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long> {
}
