package com.ssafy.banjjak.shorts.service;

import com.ssafy.banjjak.shorts.model.SearchCond;
import com.ssafy.banjjak.shorts.model.ShortDto;

import java.util.List;

public interface ShortService {
    List<ShortDto> findBySearchCond(SearchCond searchCond);
    void createShort(ShortDto shortDto);
}
