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
        memberRepository.save(new Member(request.getName(), request.getRole(), request.getWorkStartDate(), request.getBirthday()));
    }

    @Transactional
    public String getManagerNameByTeamId(Long teamId) {
        Member member = memberRepository.findByTeamId(teamId)
                //Id에 해당하는 데이터가 존재하지 않는다면 예외 처리
                .orElseThrow(IllegalArgumentException::new);

        return member.getName();
    }
}
