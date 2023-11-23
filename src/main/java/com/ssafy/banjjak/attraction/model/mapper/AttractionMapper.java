package com.ssafy.banjjak.attraction.model.mapper;

import com.ssafy.banjjak.attraction.model.AttractionDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper

public interface AttractionMapper {
    AttractionDto findById(Long attractionId);
    List<AttractionDto> findAll();
    void save(AttractionDto attractionDto);
    void update(AttractionDto attractionDto);
    void deleteById(Long attractionId);

    List<AttractionDto> listAttraction(Map<String, Object> param);

    List<AttractionDto> searchAttraction(Map<String, Object> param);
}
