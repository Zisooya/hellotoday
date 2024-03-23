package com.zisooya.hellotoday.dto.team.response;

public class TeamResponse {

    private Long id;            // 팀 ID
    private String name;        // 팀 이름
    private String manager;     // 매니저 이름
    private Long memberCount;   // 팀 인원 수

    public TeamResponse(Long id, String name, String manager, Long memberCount) {
        this.id = id;
        this.name = name;
        this.manager = manager;
        this.memberCount = memberCount;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getManager() {
        return manager;
    }

    public Long getMemberCount() {
        return memberCount;
    }
}
