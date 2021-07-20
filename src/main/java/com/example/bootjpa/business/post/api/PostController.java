package com.example.bootjpa.business.post.api;

import com.example.bootjpa.business.post.application.PostService;
import com.example.bootjpa.business.post.entity.Post;
import com.example.bootjpa.business.post.validate.PostValidate;
import com.example.bootjpa.common.message.form.MessageForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import com.example.bootjpa.business.post.form.PostForm.*;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final PostValidate postValidate;

    @PostMapping("/post")
    public ResponseEntity<MessageForm> add(@Valid @RequestBody Request.add add, HttpHeaders headers){

        postValidate.validateAdd(add);

        final Post post = Post.builder()
                              .subject(add.getSubject())
                              .content(add.getContent())
                              .build();

        postService.add(post);

        return new ResponseEntity<MessageForm>(getMessage("작성되었습니다."), headers, HttpStatus.CREATED);

    }

    @GetMapping("/post/{id}")
    public ResponseEntity<?> FindById(@PathVariable Long id){
        Post FindById = postService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(FindById);
    }

    private MessageForm getMessage(String getMessage){
        MessageForm message = MessageForm.builder().message(getMessage).build();
        return message;
    }

}
