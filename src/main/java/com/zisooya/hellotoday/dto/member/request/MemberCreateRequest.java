package com.zisooya.hellotoday.dto.member.request;

public class MemberCreateRequest {

    private String name;
    private String role;
    private String workStartDate;
    private String birthday;

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getWorkStartDate() {
        return workStartDate;
    }

    public String getBirthday() {
        return birthday;
    }
}
