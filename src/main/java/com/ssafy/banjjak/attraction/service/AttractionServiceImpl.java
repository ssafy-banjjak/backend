package com.ssafy.banjjak.attraction.service;

import com.ssafy.banjjak.attraction.model.AttractionDto;
import com.ssafy.banjjak.attraction.model.mapper.AttractionMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AttractionServiceImpl implements AttractionService{
    private final AttractionMapper attractionMapper;


    @Override
    public List<AttractionDto> listAttraction(Map<String, String> map) {
        Map<String, Object> param = new HashMap<>();
        param.put("region", map.get("region") == null ? "" : map.get("region"));
        return attractionMapper.listAttraction(param);
    }

    @Override
    public List<AttractionDto> searchAttraction(Map<String, String> map) {
        Map<String, Object> param = new HashMap<>();
        param.put("word", map.get("word") == null ? "" : map.get("word"));
        param.put("region", map.get("region") == null ? "" : map.get("region"));
        return attractionMapper.searchAttraction(param);
    }
}
