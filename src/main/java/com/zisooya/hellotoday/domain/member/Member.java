package com.zisooya.hellotoday.domain.member;

import jakarta.persistence.*;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false)
    private Long teamId = null;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(length = 25)
    private String role;

    private String birthDay;

    @Column(nullable = false)
    private String workStartDate;

    protected Member() {}

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

    public String getBirthDay() {
        return birthDay;
    }

    public String getWorkStartDate() {
        return workStartDate;
    }
}
