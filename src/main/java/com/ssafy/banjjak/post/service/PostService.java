package com.ssafy.banjjak.post.service;

import com.ssafy.banjjak.post.model.PostDetailDto;
import com.ssafy.banjjak.post.model.PostWrtieDto;

import java.util.List;
import java.util.Map;

public interface PostService {
    List<PostDetailDto> listPost(Map<String, String> map);

    void writePost(PostWrtieDto postWrtieDto);

    PostDetailDto detailPost(Long postId) throws Exception;

    void deletePost(Long postId);
}
