package com.ssafy.banjjak.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserLoginResponseDto {
    private Long userId;
    private String accessToken;
    private String refreshToken;
}
