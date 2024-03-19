package com.zisooya.hellotoday.controller.member;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    //팀 등록
    @PostMapping("/add")
    public void saveTeam(String teamName){

    }
}
