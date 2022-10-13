package com.example.circularreference.api;

import com.example.circularreference.dto.MemberRequest;
import com.example.circularreference.error.ErrorResponse;
import com.example.circularreference.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberApi {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<?> saveMember(@RequestBody MemberRequest memberRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            final List<String> errors = bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.toList());
            return ResponseEntity.badRequest().body(new ErrorResponse("400", "Validation Failure", errors));
        }
        return ResponseEntity.ok(memberService.saveMember(memberRequest.toEntity()));
    }
}
