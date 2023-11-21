package com.ssafy.banjjak.shorts.controller;

import com.ssafy.banjjak.global.BaseResponse;
import com.ssafy.banjjak.shorts.model.SearchCond;
import com.ssafy.banjjak.shorts.model.ShortDto;
import com.ssafy.banjjak.shorts.model.ShortFile;
import com.ssafy.banjjak.shorts.service.ShortService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/short")
@RequiredArgsConstructor
public class ShortController {

    private final ShortService shortService;
    @GetMapping
    public ResponseEntity<BaseResponse<List<ShortDto>>> findBySearchCond(@ModelAttribute SearchCond searchCond) {
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>("short를 가져왔습니다.", shortService.findBySearchCond(searchCond)));
    }

    @PostMapping
    public ResponseEntity<BaseResponse<?>> createShort(ShortFile shortFile) throws IOException {
        shortService.createShort(shortFile);
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>("short를 생성했습니다.", null));
    }

}
