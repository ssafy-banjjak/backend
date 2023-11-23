package com.ssafy.banjjak.post_user.controller;

import com.ssafy.banjjak.global.BaseResponse;
import com.ssafy.banjjak.post.model.PostDetailDto;
import com.ssafy.banjjak.post_user.model.PostUserDto;
import com.ssafy.banjjak.post_user.service.PostUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/postuser")
@RequiredArgsConstructor
@CrossOrigin(origins = { "*" }, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE} , maxAge = 6000)
public class PostUserController {
    private final PostUserService postUserService;

    @GetMapping("/{userId}")
    public ResponseEntity<BaseResponse<List<PostDetailDto>>> joinList(@PathVariable("userId") Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>("가입한 글 목록을 가져왔습니다.", postUserService.joinList(userId)));
    }

    @PostMapping
    public ResponseEntity<BaseResponse<?>> joinPost(@RequestBody PostUserDto postUserDto){
        postUserService.joinPost(postUserDto);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
