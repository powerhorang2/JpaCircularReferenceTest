package com.example.circularreference.dto;

import com.example.circularreference.entity.ClassRoom;
import com.example.circularreference.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class MemberResponse {

    private Long id;
    private String name;
    private List<ClassRoomResponse> classRooms;

    @Builder
    public MemberResponse(Long id, String name, List<ClassRoomResponse> classRooms) {
        this.id = id;
        this.name = name;
        this.classRooms = classRooms;
    }

    public static MemberResponse of(Member member) {
        return MemberResponse.builder()
                .id(member.getId())
                .name(member.getName())
                .classRooms(member.getClassRooms()
                        .stream()
                        .map(classRoom -> ClassRoomResponse.builder()
                                .id(classRoom.getId())
                                .name(classRoom.getName())
                                .build())
                        .collect(Collectors.toList())
                )
                .build();
    }
}
