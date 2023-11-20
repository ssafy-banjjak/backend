package com.ssafy.banjjak.user.service;

import com.ssafy.banjjak.user.model.UserDto;

public interface UserService {
    UserDto login(UserDto userDto);
    void signup(UserDto userDto);
    UserDto getUserinfo(Long userId);
    void saveRefreshToken(Long userId, String refreshToken);
    String getRefreshToken(Long userId);
    void deleteRefreshToken(Long userId);

}
