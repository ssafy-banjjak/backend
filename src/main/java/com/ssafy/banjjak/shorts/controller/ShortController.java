package com.ssafy.banjjak.shorts.controller;

import com.ssafy.banjjak.global.BaseResponse;
import com.ssafy.banjjak.shorts.model.SearchCond;
import com.ssafy.banjjak.shorts.model.ShortDto;
import com.ssafy.banjjak.shorts.service.ShortService;
import com.ssafy.banjjak.user.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/short")
@RequiredArgsConstructor
public class ShortController {

    private final ShortService shortService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<ShortDto>>> findBySearchCond(@RequestParam int pageNo,
                                                                        @RequestParam int amount,
                                                                        @RequestParam(required = false) Long userId,
                                                                        @RequestParam(required = false) String region) {
        SearchCond searchCond = new SearchCond();
        searchCond.setPageNo(pageNo);
        searchCond.setAmount(amount);
        searchCond.setUserId(userId);
        searchCond.setRegion(region);
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>("short를 가져왔습니다.", shortService.findBySearchCond(searchCond)));
    }

    @PostMapping
    public ResponseEntity<BaseResponse<?>> createShort(@RequestBody ShortDto shortDto) {
        shortService.createShort(shortDto);
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>("short를 생성했습니다.", null));
    }

}
