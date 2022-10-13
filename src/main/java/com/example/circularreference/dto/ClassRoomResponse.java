package com.example.circularreference.dto;

import com.example.circularreference.entity.ClassRoom;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ClassRoomResponse {

    private Long id;
    private String name;
    private List<MemberResponse> members;

    @Builder
    public ClassRoomResponse(Long id, String name, List<MemberResponse> members) {
        this.id = id;
        this.name = name;
        this.members = members;
    }

    public static ClassRoomResponse of(ClassRoom classRoom) {
        return ClassRoomResponse.builder()
                .id(classRoom.getId())
                .name(classRoom.getName())
                .members(classRoom.getMembers()
                        .stream()
                        .map(member -> MemberResponse.builder()
                                .id(member.getId())
                                .name(member.getName())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}
