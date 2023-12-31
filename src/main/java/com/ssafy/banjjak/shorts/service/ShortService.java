package com.ssafy.banjjak.shorts.service;

import com.ssafy.banjjak.shorts.model.SearchCond;
import com.ssafy.banjjak.shorts.model.ShortDto;
import com.ssafy.banjjak.shorts.model.ShortFile;

import java.io.IOException;
import java.util.List;

public interface ShortService {
    List<ShortDto> findBySearchCond(SearchCond searchCond);
    ShortDto findByShortId(Long shortId);
    void createShort(ShortFile shortFile) throws IOException;
    void updateLike(Long shortId);
    void updateDislike(Long shortId);
}
