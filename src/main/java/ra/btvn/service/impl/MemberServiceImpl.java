package ra.btvn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.btvn.model.dto.request.MemberDTO;
import ra.btvn.model.entity.Member;
import ra.btvn.repository.MemberRepository;
import ra.btvn.service.MemberService;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new RuntimeException("Khong co sach voi id " + id));
    }

    @Override
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member updateMember(Long id, Member member) {
        memberRepository.findById(id).orElseThrow(() -> new RuntimeException("Khong co sach id " + id));
        return memberRepository.save(member);
    }

    @Override
    public void deleteMember(Long id) {
        memberRepository.findById(id).orElseThrow(() -> new RuntimeException("Khong co sach id " + id));
        memberRepository.deleteById(id);
    }

    @Override
    public Member updateMember1(Long id, MemberDTO memberDTO){
        Member member = memberRepository.getReferenceById(id);
        if (memberDTO.getFullName() != null && !memberDTO.getFullName().isEmpty()){
            member.setFullName(memberDTO.getFullName());
        }
        if (memberDTO.getEmail() != null && !memberDTO.getEmail().isEmpty()){
            member.setEmail(memberDTO.getEmail());
        }
        if (memberDTO.getPhone() != null && !memberDTO.getPhone().isEmpty()){
            member.setPhone(memberDTO.getPhone());
        }
        return memberRepository.save(member);
    }
}
