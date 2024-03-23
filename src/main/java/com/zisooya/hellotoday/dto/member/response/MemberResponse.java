package com.zisooya.hellotoday.dto.member.response;

public class MemberResponse {
    private Long id;                //직원 id
    private String name;            //직원 이름
    private String teamName;        //소속 팀 이름
    private String role;            //직급 ("MANAGER" or "MEMBER")
    private String birthday;        //생일
    private String workStartDate;   //입사 일자

    public MemberResponse(Long id, String name, String teamName, String role, String birthday, String workStartDate) {
        this.id = id;
        this.name = name;
        this.teamName = teamName;
        this.role = role;
        this.birthday = birthday;
        this.workStartDate = workStartDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getRole() {
        return role;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getWorkStartDate() {
        return workStartDate;
    }
}
