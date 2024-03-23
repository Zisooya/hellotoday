package com.zisooya.hellotoday.service.team;

import com.zisooya.hellotoday.domain.member.Member;
import com.zisooya.hellotoday.domain.team.Team;
import com.zisooya.hellotoday.domain.team.TeamRepository;
import com.zisooya.hellotoday.dto.team.request.TeamCreatRequest;
import com.zisooya.hellotoday.dto.team.response.TeamResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @PersistenceContext
    EntityManager em;

    @PersistenceUnit
    EntityManagerFactory emf;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Transactional
    public void saveTeam(TeamCreatRequest request) {
        teamRepository.save(new Team(request.getName()));
    }

    @Transactional(readOnly = true)
    public List<TeamResponse> getTeams(){
        List<TeamResponse> response = new ArrayList<>();

        // 팀 정보 가져오기
        String query = "SELECT t FROM Team t LEFT JOIN FETCH t.members";
        List<Team> teams = em.createQuery(query, Team.class).getResultList();

        String manager;
        Long memberCount;

        for (Team team : teams) {
            manager = null;       // 매니저 이름
            memberCount = 0L;   // 팀 인원수

            List<Member> members = team.getMembers();

            for (Member member : members) {
                memberCount++;

                if(member.getRole().equals("MANAGER")){
                    manager = member.getName();
                }
            }

            TeamResponse teamInfo = new TeamResponse(team.getId(), team.getName(), manager, memberCount);
            response.add(teamInfo);

            System.out.println("--------------------------------"); // 각 팀 사이에 빈 줄 추가
        }

        return response;
    }

}


