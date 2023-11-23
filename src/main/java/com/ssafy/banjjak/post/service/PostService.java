package com.ssafy.banjjak.post.service;

import com.ssafy.banjjak.post.model.PostDetailDto;
import com.ssafy.banjjak.post.model.PostDto;
import com.ssafy.banjjak.post.model.PostWrtieDto;

import java.util.List;

public interface PostService {
    List<PostDetailDto> listPost();

    void writePost(PostWrtieDto postWrtieDto);

    PostDetailDto detailPost(Long postId) throws Exception;

    void deletePost(Long postId);
}
