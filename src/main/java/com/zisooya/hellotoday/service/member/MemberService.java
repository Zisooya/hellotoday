package com.zisooya.hellotoday.service.member;

import com.zisooya.hellotoday.domain.member.Member;
import com.zisooya.hellotoday.domain.member.MemberRepository;
import com.zisooya.hellotoday.domain.team.Team;
import com.zisooya.hellotoday.dto.member.request.MemberCreateRequest;
import com.zisooya.hellotoday.dto.member.response.MemberResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Transactional
    public List<MemberResponse> getMembers() {
        List<MemberResponse> response = new ArrayList<>();

        // 직원 정보 가져오기
        String query = "SELECT m FROM Member m LEFT JOIN FETCH m.team";
        List<Member> members = em.createQuery(query, Member.class).getResultList();

        for (Member member : members) {
            response.add(new MemberResponse(member.getId(), member.getName(), member.getTeam().getName(), member.getRole(), member.getWorkStartDate(), member.getBirthday()));
        }

        return response;
    }

}
