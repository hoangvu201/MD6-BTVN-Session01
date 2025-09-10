package ra.btvn.service;

import ra.btvn.model.entity.BorrowDetail;

import java.util.List;

public interface BorrowDetailService {
    BorrowDetail createBorrowDetail(BorrowDetail borrowDetail,Long bookId, Long borrowId, Integer quantity);

    List<BorrowDetail> getBorrowDetailsByBorrowId(Long borrowId);
}
