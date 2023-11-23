package com.ssafy.banjjak.user.service;

import com.ssafy.banjjak.global.BaseException;
import com.ssafy.banjjak.user.model.UserLoginResponseDto;
import com.ssafy.banjjak.user.model.UserDto;
import com.ssafy.banjjak.user.model.mapper.UserMapper;
import com.ssafy.banjjak.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;
    private final JWTUtil jwtUtil;

    @Override
    public UserLoginResponseDto login(UserDto userDto) {
        UserDto findUser = userMapper.findByUsername(userDto.getUsername());
        if (findUser == null){
            throw new BaseException(HttpStatus.NO_CONTENT.value(), "회원정보가 일치하지 않습니다.");
        }

        String accessToken = jwtUtil.createAccessToken(findUser.getUserId());
        String refreshToken = jwtUtil.createRefreshToken(findUser.getUserId());
        Map<String ,Object> map = new HashMap<>();
        map.put("userId", userDto.getUserId());
        map.put("token", refreshToken);
        userMapper.saveRefreshToken(map);
        return new UserLoginResponseDto(findUser.getUserId(), accessToken, refreshToken);
    }

    @Override
    public void signup(UserDto userDto) {
        UserDto findUser = userMapper.findByUsername(userDto.getUsername());
        if(findUser != null){
            throw new BaseException(HttpStatus.CONFLICT.value(), "이미 존재하는 유저입니다.");
        }
        userMapper.save(userDto);
    }

    @Override
    public UserDto getUserinfo(Long userId) {
        return userMapper.findById(userId);
    }

    @Override
    public void saveRefreshToken(Long userId, String refreshToken) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", userId);
        map.put("token", refreshToken);
        userMapper.saveRefreshToken(map);
    }

    @Override
    public String getRefreshToken(Long userId) {
        return userMapper.getRefreshToken(userId);
    }

    @Override
    public void deleteRefreshToken(Long userId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", userId);
        map.put("token", null);
        userMapper.deleteRefreshToken(map);
    }

    @Override
    public UserLoginResponseDto reissue(Long userId, HttpServletRequest request) {
        String token = request.getHeader("refreshToken");
        if (!jwtUtil.checkToken(token) || !token.equals(userMapper.getRefreshToken(userId))) {
            throw new BaseException(HttpStatus.UNAUTHORIZED.value(), "잘못된 토큰입니다.");
        }
        return new UserLoginResponseDto(userId, jwtUtil.createAccessToken(userId), jwtUtil.createRefreshToken(userId));
    }
}
