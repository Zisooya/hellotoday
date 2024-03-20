package com.zisooya.hellotoday.controller.member;

import com.zisooya.hellotoday.dto.member.request.MemberCreateRequest;
import com.zisooya.hellotoday.service.member.MemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //직원 등록
    @PostMapping("/member")
    public void saveMember(@RequestBody MemberCreateRequest request) {
        memberService.saveMember(request);
    }


}
