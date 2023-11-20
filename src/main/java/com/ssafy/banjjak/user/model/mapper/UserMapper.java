package com.ssafy.banjjak.user.model.mapper;

import com.ssafy.banjjak.user.model.UserDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

@Mapper

public interface UserMapper {
    UserDto findById(Long userId);
    List<UserDto> findAll();
    void save(UserDto userDto);
    void update(UserDto userDto);
    void deleteById(Long userId);
    //----기본 crud----
    UserDto login(UserDto userDto);
    UserDto findByUsername(String username);
    void saveRefreshToken(Map<String, Object> map);
    String getRefreshToken(Long userId);
    void deleteRefreshToken(Map<String, Object> map);
}
