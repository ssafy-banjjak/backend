package com.ssafy.banjjak.user.model.mapper;

import com.ssafy.banjjak.user.model.UserDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper

public interface UserMapper {
    UserDto findById(Long userId);
    List<UserDto> findAll();
    void save(UserDto userDto);
    void update(UserDto userDto);
    void deleteById(Long userId);
}
