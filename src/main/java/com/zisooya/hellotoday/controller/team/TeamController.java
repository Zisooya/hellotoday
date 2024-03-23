package com.zisooya.hellotoday.controller.team;

import com.zisooya.hellotoday.dto.team.request.TeamCreatRequest;
import com.zisooya.hellotoday.dto.team.response.TeamResponse;
import com.zisooya.hellotoday.service.team.TeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    //팀 등록
    @PostMapping("/team")
    public void saveTeam(@RequestBody TeamCreatRequest request) {
        teamService.saveTeam(request);
    }

    //팀 전체 조회
    @GetMapping("/team")
    public List<TeamResponse> getTeams() {
        return teamService.getTeams();
    }
}
