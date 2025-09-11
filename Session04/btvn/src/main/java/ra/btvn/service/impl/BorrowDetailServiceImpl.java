package ra.btvn.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.btvn.model.entity.Book;
import ra.btvn.model.entity.Borrow;
import ra.btvn.model.entity.BorrowDetail;
import ra.btvn.repository.BookRepository;
import ra.btvn.repository.BorrowDetailRepository;
import ra.btvn.repository.BorrowRepository;
import ra.btvn.service.BorrowDetailService;

import java.util.List;

@Service
public class BorrowDetailServiceImpl implements BorrowDetailService {
    @Autowired
    private BorrowDetailRepository borrowDetailRepository;

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BorrowDetail createBorrowDetail(BorrowDetail borrowDetail,Long bookId, Long borrowId, Integer quantity) {
        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0.");
        }

        Borrow borrow = borrowRepository.findById(bookId).orElseThrow(()->new EntityNotFoundException("Borrow not found with id " + borrowId));

        Book book = bookRepository.findById(bookId).orElseThrow(()->new EntityNotFoundException("Book not found with id " + bookId));

        borrowDetail.setBorrow(borrow);
        borrowDetail.setBook(book);
        borrowDetail.setQuantity(quantity);
        return borrowDetailRepository.save(borrowDetail);
    }

    @Override
    public List<BorrowDetail> getBorrowDetailsByBorrowId(Long borrowId) {
        return borrowDetailRepository.findByBorrow_Id(borrowId);
    }
}
