package com.example.bootjpa.business.member.application;

import com.example.bootjpa.business.member.entity.Member;
import com.example.bootjpa.common.error.code.ErrorCode;
import com.example.bootjpa.common.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository accountRepository;

    @Transactional
    public void join(Member account){
        accountRepository.save(account);
    }

    @Transactional
    public Member findByEmail(String email){
        return accountRepository.findByEmail(email)
                                .orElseThrow(() -> new BusinessException(ErrorCode.NOT_FOUND_EMAIL));
    }

}
