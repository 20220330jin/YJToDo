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
    public static class search {
        private long id;

        private String name;

        private String username;

        private LocalDateTime createDateTime;

        public search(long id, String name, String username, LocalDateTime createDateTime){
            this.id = id;
            this.name = name;
            this.username = username;
            this.createDateTime = createDateTime;
        }
    }
    
    @Getter 
    public static class idFind {
        private String name;

        private String username;

        private LocalDateTime createDateTime;

        private String email;

        public idFind(String name, String username, LocalDateTime createDateTime, String email){
            this.name = name;
            this.username = username;
            this.createDateTime = createDateTime;
            this.email = email;
        }
    }

    @Getter
    @Setter
    public static class searchParam {

        // 검색어
        private String searchKeyword;

        // 검색타입 : name(가입자이름) / username(가입자가 만든 아이디)
        private String searchType;
        
    }

    @Getter
    public static class detailRead {
        private Long id;

        private String name;

        private String username;

        private LocalDateTime createDateTime;

        private Character useYn;

        private Character delYn;

        private String memberType;

        private String email;

        public detailRead(Long id, String name, String username, LocalDateTime createDateTime, Character useYn, Character delYn, MemberTypeEnum memberType, String email){
            this.id = id;
            this.name = name;
            this.username = username;
            this.createDateTime = createDateTime;
            this.delYn = delYn;
            this.useYn = useYn;
            this.memberType = memberType.getDescription();
            this.email = email;
        }
    }
    @Getter
    @Setter
    public static class detailReadParam {
        private Long detailParamsId;
    }

    @Getter
    public static class signupCheck {
        private String username;

        private String name;

        public signupCheck(String username, String name){
            this.username = username;
            this.name = name;
        }
    }
    @Getter
    @Setter
    public static class signupCheckParam {
        private String signupCheckParam;
    }
    @Getter
    @Setter
    public static class idFindParam {
        private String name;
        private String email;
    }
    @Getter
    @Setter
    public static class pwFindParam {
        private String name;
        private String username;
    }
  
   

}
