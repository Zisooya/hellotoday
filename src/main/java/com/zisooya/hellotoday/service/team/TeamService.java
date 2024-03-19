package com.zisooya.hellotoday.service.team;

import com.zisooya.hellotoday.domain.team.Team;
import com.zisooya.hellotoday.domain.team.TeamRepository;
import com.zisooya.hellotoday.dto.team.request.TeamCreatRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Transactional
    public void saveTeam(TeamCreatRequest request) {
        teamRepository.save(new Team(request.getName()));
    }

}


