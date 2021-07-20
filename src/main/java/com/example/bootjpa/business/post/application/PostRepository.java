package com.example.bootjpa.business.post.application;

import com.example.bootjpa.business.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAll(Post post);

    Optional<Post> findById(Long id);

}
