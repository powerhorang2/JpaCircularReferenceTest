package com.example.circularreference.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "member_classroom", joinColumns = @JoinColumn(name = "member_id"), inverseJoinColumns = @JoinColumn(name = "classroom_id"))
    private List<ClassRoom> classRooms = new ArrayList<>();

    @Builder
    public Member(String name) {
        this.name = name;
    }
}
