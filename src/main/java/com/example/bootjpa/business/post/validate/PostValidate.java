package com.example.bootjpa.business.post.validate;

import com.example.bootjpa.business.post.application.PostRepository;
import com.example.bootjpa.business.post.application.PostService;
import com.example.bootjpa.common.error.code.ErrorCode;
import com.example.bootjpa.common.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.example.bootjpa.business.post.form.PostForm.*;

@Component
@RequiredArgsConstructor
public class PostValidate {

    private final PostService postService;
    private final PostRepository postRepository;

    public void validateAdd(Request.add add){
        validTypeSubject(add.getSubject());
        validTypeContent(add.getContent());
    }


    private void validTypeSubject(String subject){

        if(subject == null)
            throw new BusinessException(ErrorCode.NOT_TYPE_SUBJECT);

    }

    private void validTypeContent(String content){

        if(content == null)
            throw new BusinessException(ErrorCode.NOT_TYPE_CONTENT);

    }

}
