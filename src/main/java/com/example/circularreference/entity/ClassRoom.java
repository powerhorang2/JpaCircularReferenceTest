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
public class ClassRoom {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classroom_id")
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "classRooms")
    private List<Member> members = new ArrayList<>();

    @Builder
    public ClassRoom(String name) {
        this.name = name;
    }
}
