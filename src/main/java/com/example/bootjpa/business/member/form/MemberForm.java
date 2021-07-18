package com.example.bootjpa.business.member.form;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class MemberForm {

    public static class Request {

        @Getter
        @Setter
        @NoArgsConstructor
        public static class join {

            @NotBlank(message = "이메일을 입력해주세요.")
            @Email(message = "이메일 형식으로 입력해주세요.")
            private String email;

            @NotBlank(message = "비밀번호를 입력해주세요.")
            private String password;

            @NotBlank(message = "비밀번호 확인을 입력해주세요.")
            private String repeatPassword;

        }

        @Getter
        @Setter
        public static class login {
            private String email;
            private String password;
        }

    }

    public static class Response {

        @Getter
        @Setter
        public static class find {
            private String email;

            private find(String email){
                this.email = email;
            }
        }


    }

}
