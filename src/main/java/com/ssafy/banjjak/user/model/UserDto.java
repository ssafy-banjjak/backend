package com.ssafy.banjjak.user.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDto {

    private Long userId;
    private String username;
    private String password;
    private String nickname;
    private String name;
    private String region;
    private Timestamp createDate;
    private String refreshToken;
}
