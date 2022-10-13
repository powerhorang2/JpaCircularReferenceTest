package com.example.circularreference.service;

import com.example.circularreference.dto.MemberResponse;
import com.example.circularreference.entity.Member;

public interface MemberService {

    MemberResponse saveMember(Member member);
}
