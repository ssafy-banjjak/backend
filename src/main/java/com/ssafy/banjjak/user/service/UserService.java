package com.ssafy.banjjak.user.service;

import com.ssafy.banjjak.user.model.UserLoginResponseDto;
import com.ssafy.banjjak.user.model.UserDto;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    UserLoginResponseDto login(UserDto userDto);
    void signup(UserDto userDto);
    UserDto getUserinfo(Long userId);
    void saveRefreshToken(Long userId, String refreshToken);
    String getRefreshToken(Long userId);
    void deleteRefreshToken(Long userId);
    UserLoginResponseDto reissue(Long userId, HttpServletRequest request);
}
