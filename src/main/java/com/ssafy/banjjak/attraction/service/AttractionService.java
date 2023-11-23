package com.ssafy.banjjak.attraction.service;

import com.ssafy.banjjak.attraction.model.AttractionDto;

import java.util.List;
import java.util.Map;

public interface AttractionService {
    List<AttractionDto> listAttraction(Map<String, String> region);

    List<AttractionDto> searchAttraction(Map<String, String> map);
}
