package com.zisooya.hellotoday.controller.member;

import com.zisooya.hellotoday.dto.member.request.MemberCreateRequest;
import com.zisooya.hellotoday.dto.member.response.MemberResponse;
import com.zisooya.hellotoday.service.member.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    //직원 전체 조회
    @GetMapping("/member")
    public List<MemberResponse> getMembers() {
        return memberService.getMembers();
    }

}
