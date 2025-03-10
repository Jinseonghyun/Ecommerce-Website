package com.backend.user.domain.repository;

import com.backend.user.domain.portone.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
