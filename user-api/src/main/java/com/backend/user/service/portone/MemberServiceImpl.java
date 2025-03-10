package com.backend.user.service.portone;

import com.backend.user.domain.portone.Member;
import com.backend.user.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    // 회원 자동 생성
    @Override
    public Member autoRegister() {
        Member member = Member.builder()
                .username(UUID.randomUUID().toString())
                .email("example@example.com")
                .address("서울특별시 서초구 역삼동")
                .build();

        return memberRepository.save(member);
    }
}
