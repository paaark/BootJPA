package com.example.bootjpa.business.member.validate;

import com.example.bootjpa.business.member.application.MemberRepository;
import com.example.bootjpa.business.member.application.MemberService;
import com.example.bootjpa.common.error.code.ErrorCode;
import com.example.bootjpa.common.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


import com.example.bootjpa.business.member.form.MemberForm.*;

@Component
@RequiredArgsConstructor
public class MemberValidate {

    private final MemberService memberService;
    private final MemberRepository memberRepository;

    public void validateJoin(Request.join join){
        validEmailDuplicate(join.getEmail());
        validPasswordEquals(join.getPassword(), join.getRepeatPassword());
    }

    private void validEmailDuplicate(String email){
        boolean result = memberRepository.existsByEmail(email);

        if("false".equals(result))
            throw new BusinessException(ErrorCode.DUPLICATE_EMAIL);

    }

    private void validPasswordEquals(String password, String repeatPassword){
        if(!password.equals(repeatPassword))
            throw new BusinessException(ErrorCode.NOT_EQUAL_PASSWORD);
    }



}
