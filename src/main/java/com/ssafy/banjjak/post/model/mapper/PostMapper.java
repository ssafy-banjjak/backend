package com.ssafy.banjjak.post.model.mapper;

import com.ssafy.banjjak.post.model.PostDetailDto;
import com.ssafy.banjjak.post.model.PostDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper

public interface PostMapper {
    PostDto findById(Long postId);
    List<PostDto> findAll();

    // 글쓰기
    void writePost(PostDto postDto);
    void update(PostDto attractionDto);
    void deleteById(Long postId);

    List<PostDetailDto> listPost(Map<String, Object> param);

    PostDetailDto detailPost(Long postId);

    void deletePost(Long postId);
}
