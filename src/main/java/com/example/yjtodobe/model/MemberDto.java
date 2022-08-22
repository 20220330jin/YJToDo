package com.example.yjtodobe.model;

import java.time.LocalDateTime;

import com.example.yjtodobe.domain.MemberTypeEnum;

import lombok.Getter;
import lombok.Setter;

public class MemberDto {

    @Getter
    @Setter
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
    @Setter
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
    
    @Getter
    public static class list {
        private Long id;

        private String name;

        private String username;

        private LocalDateTime createDateTime;

        // private Character useYn;

        // private Character delYn;

        public list(Long id, String name, String username, LocalDateTime createDateTime){
            this.id = id;
            this.name = name;
            this.username = username;
            this.createDateTime = createDateTime;
            // this.delYn = delYn;
            // this.useYn = useYn;
        }
    }

    @Getter
    public static class detailRead {
        private Long id;

        private String name;

        private String username;

        private LocalDateTime createDateTime;

        private Character useYn;

        private Character delYn;

        private MemberTypeEnum memberType;

        public detailRead(Long id, String name, String username, LocalDateTime createDateTime, Character useYn, Character delYn, MemberTypeEnum memberType){
            this.id = id;
            this.name = name;
            this.username = username;
            this.createDateTime = createDateTime;
            this.delYn = delYn;
            this.useYn = useYn;
            this.memberType = memberType;
        }
    }
    @Getter
    @Setter
    public static class detailReadParam {
        private Long detailParamsId;
    }
}
