package com.zisooya.hellotoday.domain.team;

import com.zisooya.hellotoday.domain.member.Member;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(nullable = false, length = 25)
    private String name;

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<Member>();

    protected Team() {
    }

    public Team(String name) {
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다.", name));
        }
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Member> getMembers() {
        return members;
    }
}
