package com.example.bootjpa.business.member.api;

import com.example.bootjpa.business.member.application.MemberService;
import com.example.bootjpa.business.member.entity.Member;
import com.example.bootjpa.business.member.validate.MemberValidate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import com.example.bootjpa.business.member.form.MemberForm.*;
import com.example.bootjpa.common.message.form.MessageForm;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberValidate memberValidate;

    @PostMapping("/join")
    public ResponseEntity<MessageForm> join(@Valid @RequestBody Request.join join, HttpHeaders headers){
        memberValidate.validateJoin(join);

        final Member member = Member.builder()
                                    .email(join.getEmail())
                                    .password(join.getPassword())
                                    .build();

        memberService.join(member);

        return new ResponseEntity<MessageForm>(getMessage("가입되었습니다."), headers, HttpStatus.CREATED);
    }

    private MessageForm getMessage(String getMessage){
        MessageForm message = MessageForm.builder().message(getMessage).build();
        return message;
    }

}
