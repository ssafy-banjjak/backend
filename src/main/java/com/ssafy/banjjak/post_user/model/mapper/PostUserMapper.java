package com.ssafy.banjjak.post_user.model.mapper;

import com.ssafy.banjjak.post.model.PostDetailDto;
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

    // 글 번호로 글에 가입한 유저 목록 가져오기
    List<PostUserDto> getPostUser(Long postId);

    void joinPost(PostUserDto postUserDto);
    void unJoinPost(PostUserDto postUserDto);

    // 유저 번호로 유저가 가입한 글 번호 목록 가져오기
    List<Long> userPostList(Long userId);

    PostDetailDto joinList(Long postId);

    int canJoinPost(PostUserDto postUserDto);
}
