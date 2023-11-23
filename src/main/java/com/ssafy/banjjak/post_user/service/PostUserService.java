package com.ssafy.banjjak.post_user.service;

import com.ssafy.banjjak.post.model.PostDetailDto;
import com.ssafy.banjjak.post_user.model.PostUserDto;

import java.util.List;

public interface PostUserService {
    void joinPost(PostUserDto postUserDto);

    List<PostDetailDto> joinList(Long userId);
}
