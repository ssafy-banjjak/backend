package com.ssafy.banjjak.post.model.mapper;

import com.ssafy.banjjak.post.model.PostDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface PostMapper {
    PostDto findById(Long postId);
    List<PostDto> findAll();
    void save(PostDto attractionDto);
    void update(PostDto attractionDto);
    void deleteById(Long postId);
}
