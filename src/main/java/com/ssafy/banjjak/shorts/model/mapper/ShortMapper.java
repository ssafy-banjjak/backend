package com.ssafy.banjjak.shorts.model.mapper;

import com.ssafy.banjjak.shorts.model.ShortDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper

public interface ShortMapper {
    ShortDto findById(Long shortId);
    List<ShortDto> findAll();
    void save(ShortDto shortDto);
    void update(ShortDto shortDto);
    void deleteById(Long shortId);
}
