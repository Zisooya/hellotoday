package com.zisooya.hellotoday.service.member;

import com.zisooya.hellotoday.domain.member.Member;
import com.zisooya.hellotoday.domain.member.MemberRepository;
import com.zisooya.hellotoday.domain.team.Team;
import com.zisooya.hellotoday.dto.member.request.MemberCreateRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @PersistenceContext
    EntityManager em;

    @PersistenceUnit
    EntityManagerFactory emf;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public void saveMember(MemberCreateRequest request) {
        Team team = Team.createTeam(request.getTeamId());
        memberRepository.save(new Member(team, request.getName(), request.getRole(), request.getWorkStartDate(), request.getBirthday()));
    }

}
