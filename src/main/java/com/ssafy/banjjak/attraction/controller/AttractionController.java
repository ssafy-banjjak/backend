package com.ssafy.banjjak.attraction.controller;

import com.ssafy.banjjak.attraction.model.AttractionDto;
import com.ssafy.banjjak.attraction.service.AttractionService;
import com.ssafy.banjjak.global.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/attraction")
@RequiredArgsConstructor
@CrossOrigin(origins = { "*" }, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.POST} , maxAge = 6000)
public class AttractionController {
    private final AttractionService attractionService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<AttractionDto>>> listAttraction(@RequestParam Map<String, String> map){
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>("관광지 목록을 가져왔습니다.", attractionService.listAttraction(map)));
    }

    @GetMapping("/search")
    public ResponseEntity<BaseResponse<List<AttractionDto>>> searchAttraction(@RequestParam Map<String, String> map){
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>("관광지 검색 목록을 가져왔습니다.", attractionService.searchAttraction(map)));
    }
}
