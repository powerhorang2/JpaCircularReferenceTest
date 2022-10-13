package com.example.circularreference.dto;

import com.example.circularreference.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberRequest {

    private String name;

    @Builder
    public MemberRequest(String name) {
        this.name = name;
    }

    public Member toEntity() {
        return Member.builder()
                .name(this.name)
                .build();
    }
}
