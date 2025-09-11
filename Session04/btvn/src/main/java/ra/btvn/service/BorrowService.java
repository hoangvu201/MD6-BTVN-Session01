package ra.btvn.service;


import ra.btvn.model.entity.Borrow;

import java.util.List;

public interface BorrowService {
    Borrow createBorrow(Borrow borrow,Long memberId);
    List<Borrow> getAllBorrows();
}
