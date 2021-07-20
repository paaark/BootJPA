package com.example.bootjpa.business.post.application;

import com.example.bootjpa.business.post.entity.Post;
import com.example.bootjpa.common.error.code.ErrorCode;
import com.example.bootjpa.common.error.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public List<Post> findAll(){
        return postRepository.findAll();
    }

    @Transactional
    public Post findById(Long id){
        return postRepository.findById(id).orElseThrow(() -> new BusinessException(ErrorCode.NOT_FOUND_POST));
    }

    @Transactional
    public Post add(Post post){
        return postRepository.save(post);
    }


}
