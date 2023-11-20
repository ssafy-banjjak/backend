package com.ssafy.banjjak.user.service;

import com.ssafy.banjjak.global.BaseException;
import com.ssafy.banjjak.user.model.UserDto;
import com.ssafy.banjjak.user.model.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;

    @Override
    public UserDto login(UserDto userDto) {
        UserDto loginUser = userMapper.login(userDto);
        if (loginUser == null){
            throw new BaseException(HttpStatus.NO_CONTENT.value(), "회원정보가 일치하지 않습니다.");
        }
        return loginUser;
    }

    @Override
    public void signup(UserDto userDto) {
        UserDto findUser = userMapper.findByUsername(userDto.getUsername());
        if(findUser != null){
            throw new BaseException(HttpStatus.CONFLICT.value(), "이미 있는 유저입니다.");
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
        log.info("userId: {}", userId);
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
}
