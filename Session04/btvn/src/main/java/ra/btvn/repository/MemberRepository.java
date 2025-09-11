package ra.btvn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.btvn.model.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
}
