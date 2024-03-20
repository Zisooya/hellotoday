package com.zisooya.hellotoday.domain.member;

import jakarta.persistence.*;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id = null;

    private Long teamId = null;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(length = 25)
    private String role;

    private String birthday;

    @Column(nullable = false)
    private String workStartDate;

    protected Member() {}


    public Member(String name, String role, String workStartDate, String birthday) {
        this.name = name;
        this.role = role;
        this.workStartDate = workStartDate;
        this.birthday = birthday;
    }

    public Long getId() {

        return id;
    }

    public Long getTeamId() {
        return teamId;
    }

    public String getName() {
        return name;
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
