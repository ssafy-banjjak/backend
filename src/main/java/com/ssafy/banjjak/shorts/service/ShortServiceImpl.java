package com.ssafy.banjjak.shorts.service;

import com.ssafy.banjjak.shorts.model.SearchCond;
import com.ssafy.banjjak.shorts.model.ShortDto;
import com.ssafy.banjjak.shorts.model.mapper.ShortMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ShortServiceImpl implements ShortService {

    private final ShortMapper shortMapper;

    @Override
    public List<ShortDto> findBySearchCond(SearchCond searchCond) {
        int currentPage = searchCond.getPageNo();
        int sizePerPage = searchCond.getAmount();
        searchCond.setPageNo(currentPage*sizePerPage-sizePerPage);
        return shortMapper.findAllWithSearchCond(searchCond);
    }

    @Override
    public void createShort(ShortDto shortDto) {
        shortMapper.save(shortDto);
    }
}
