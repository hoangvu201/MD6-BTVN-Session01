package ra.btvn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.btvn.model.entity.Borrow;
import ra.btvn.model.entity.Member;
import ra.btvn.repository.BorrowRepository;
import ra.btvn.repository.MemberRepository;
import ra.btvn.service.BorrowService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Borrow createBorrow(Borrow borrow, Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(()->new RuntimeException("Member not found"));
        borrow.setMember(member);
        borrow.setBorrowDate(LocalDateTime.now());
        return borrowRepository.save(borrow);
    }

    @Override
    public List<Borrow> getAllBorrows() {
        return borrowRepository.findAll();
    }
}
