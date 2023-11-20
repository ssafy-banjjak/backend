package com.ssafy.banjjak.post_attraction.model.mapper;

import com.ssafy.banjjak.post_attraction.model.PostAttractionDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface PostAttractionMapper {
    PostAttractionDto findById(Long postAttractionId);
    List<PostAttractionDto> findAll();
    void save(PostAttractionDto postAttractionDto);
    void update(PostAttractionDto postAttractionDto);
    void deleteById(Long postAttractionId);
}
