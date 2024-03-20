package com.zisooya.hellotoday.service.member;

import com.zisooya.hellotoday.domain.member.Member;
import com.zisooya.hellotoday.domain.member.MemberRepository;
import com.zisooya.hellotoday.dto.member.request.MemberCreateRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void saveMember(MemberCreateRequest request){
        System.out.println("birth: " + request.getBirthday());
        memberRepository.save(new Member(request.getName(), request.getRole(), request.getWorkStartDate(), request.getBirthday()));
    }
}
