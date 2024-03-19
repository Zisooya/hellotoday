package com.zisooya.hellotoday.controller.team;

import com.zisooya.hellotoday.dto.team.request.TeamCreatRequest;
import com.zisooya.hellotoday.service.team.TeamService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    //팀 등록
    @PostMapping("/team")
    public void saveTeam(@RequestBody TeamCreatRequest request){
        teamService.saveTeam(request);
    }
}
