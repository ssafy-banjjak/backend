package com.ssafy.banjjak.shorts.controller;

import com.ssafy.banjjak.global.BaseResponse;
import com.ssafy.banjjak.shorts.model.SearchCond;
import com.ssafy.banjjak.shorts.model.ShortDto;
import com.ssafy.banjjak.shorts.model.ShortFile;
import com.ssafy.banjjak.shorts.service.ShortService;
import io.swagger.annotations.ApiOperation;
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
@CrossOrigin
public class ShortController {

    private final ShortService shortService;

    @ApiOperation(value = "반짝 가져오기")
    @GetMapping
    public ResponseEntity<BaseResponse<List<ShortDto>>> findBySearchCond(@ModelAttribute SearchCond searchCond) {
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>("short를 가져왔습니다.", shortService.findBySearchCond(searchCond)));
    }

    @ApiOperation(value = "반짝 가져오기")
    @GetMapping("/{shortId}")
    public ResponseEntity<BaseResponse<ShortDto>> findByShortId(@PathVariable Long shortId) {
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>("shortid를 가져왔습니다.", shortService.findByShortId(shortId)));
    }

    @ApiOperation(value = "반짝 등록하기")
    @PostMapping
    public ResponseEntity<BaseResponse<?>> createShort(ShortFile shortFile) throws IOException {
        shortService.createShort(shortFile);
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>("short를 생성했습니다.", null));
    }

    @ApiOperation(value = "반짝 좋아요")
    @PatchMapping("/{shortId}/like")
    public ResponseEntity<BaseResponse<?>> likeShort(@PathVariable Long shortId) {
        shortService.updateLike(shortId);
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>("short 좋아요를 눌렀습니다.", null));
    }

    @ApiOperation(value = "반짝 싫어요")
    @PatchMapping("/{shortId}/dislike")
    public ResponseEntity<BaseResponse<?>> dislikeShort(@PathVariable Long shortId) {
        shortService.updateDislike(shortId);
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>("short 싫어요를 눌렀습니다.", null));
    }
}
