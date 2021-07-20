package com.example.bootjpa.business.post.entity;


import com.example.bootjpa.common.domain.BaseEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Post  extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder
    private Post(Long id, String subject, String content){
        this.id = id;
        this.subject = subject;
        this.content = content;
    }

}
