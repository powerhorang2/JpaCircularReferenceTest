package com.example.circularreference.service;

import com.example.circularreference.dto.MemberResponse;
import com.example.circularreference.entity.Member;
import com.example.circularreference.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public MemberResponse saveMember(Member member) {

        Member saveMember = memberRepository.save(member);

        return MemberResponse.of(saveMember);
    }
}
