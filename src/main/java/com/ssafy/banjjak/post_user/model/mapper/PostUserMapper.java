package com.ssafy.banjjak.post_user.model.mapper;

import com.ssafy.banjjak.post_user.model.PostUserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface PostUserMapper {
    PostUserDto findById(Long postUserId);
    List<PostUserDto> findAll();
    void save(PostUserDto postUserDto);
    void update(PostUserDto postUserDto);
    void deleteById(Long postUserId);

    List<PostUserDto> getPostUser(Long postId);

    void joinPost(PostUserDto postUserDto);
}
