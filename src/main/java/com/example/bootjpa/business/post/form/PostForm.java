package com.example.bootjpa.business.post.form;

import com.example.bootjpa.business.post.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class PostForm {

    public static class Request {

        @Getter
        @Setter
        @NoArgsConstructor
        public static class add{

            @NotBlank(message = "제목을 입력해주세요.")
            private String subject;

            @NotBlank(message = "내용을 입력해주세요.")
            private String content;

            public Post toEntity(){
                return Post.builder()
                        .subject(subject)
                        .content(content)
                        .build();
            }

        }

        @Getter
        @Setter
        @NoArgsConstructor
        public static class modify{

            @NotBlank(message = "제목을 입력해주세요.")
            private String subject;

            @NotBlank(message = "내용을 입력해주세요.")
            private String content;

            public Post toEntity(){
                return Post.builder()
                        .subject(subject)
                        .content(content)
                        .build();
            }


        }

    }

    public static class Response{

        @Getter
        @Setter
        public static class findAll {
            private String subject;
            private String content;

            private findAll(String subject, String content){
                this.subject = subject;
                this.content = content;
            }
        }


        @Getter
        @Setter
        public static class findById {
            private Long id;
            private String subject;
            private String content;

            private findById(Long id,String subject, String content){
                this.id = id;
                this.subject = subject;
                this.content = content;
            }
        }

    }


}
