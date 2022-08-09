package com.example.yjtodobe.model;

import lombok.Getter;

public class MemberDto {

    public static class login {
        private String username;
        private String nickname;
        private String success;
        private String token;

        public login(String username, String nickname, String success, String token){
            this.username = username;
            this.nickname = nickname;
            this.success = success;
            this.token = token;
        }
    }

    @Getter
    public static class loginParam {

        private String username;

        private String password;

    }

    public static class signup {

    }

    @Getter
    public static class signupParam {
        private String username;

        private String password;

        private String name;

        private String email;
    }
}
