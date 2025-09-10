package ra.btvn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.btvn.model.entity.BorrowDetail;

import java.util.List;

@Repository
public interface BorrowDetailRepository extends JpaRepository<BorrowDetail,Long> {
    List<BorrowDetail> findByBorrow_Id(Long borrowId);
}
