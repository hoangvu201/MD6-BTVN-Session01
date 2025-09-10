package ra.btvn.service;

import ra.btvn.model.dto.request.MemberDTO;
import ra.btvn.model.entity.Member;

import java.util.List;

public interface MemberService {
    List<Member> getAllMembers();

    Member getMemberById(Long id);

    Member createMember(Member member);

    Member updateMember(Long id, Member member);

    void deleteMember(Long id);

    Member updateMember1(Long id, MemberDTO memberDTO);
}
