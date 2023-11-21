package com.ssafy.banjjak.post.controller;

import com.ssafy.banjjak.global.BaseException;
import com.ssafy.banjjak.global.BaseResponse;
import com.ssafy.banjjak.post.model.PostDetailDto;
import com.ssafy.banjjak.post.model.PostDto;
import com.ssafy.banjjak.post.model.PostWrtieDto;
import com.ssafy.banjjak.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
@CrossOrigin(origins = { "*" }, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.POST} , maxAge = 6000)
public class PostController {
    private final PostService postService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<PostDetailDto>>> listPost(){
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>("글 목록을 가져왔습니다.", postService.listPost()));
    }

    @PostMapping
    public ResponseEntity<BaseResponse<?>> writePost(@RequestBody PostWrtieDto postWrtieDto){
        postService.writePost(postWrtieDto);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<BaseResponse<PostDetailDto>> detailPost(@PathVariable("postId") Long postId){
        PostDetailDto postDetailDto = null;
        try {
            postDetailDto = postService.detailPost(postId);
        } catch (Exception e){
            log.error("실패 : {}",e);
            throw new BaseException(HttpStatus.BAD_REQUEST.value(), "오류!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>("글 정보를 가져왔습니다.", postDetailDto));
    }
}
