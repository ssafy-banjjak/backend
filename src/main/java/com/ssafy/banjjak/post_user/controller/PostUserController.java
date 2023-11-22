package com.ssafy.banjjak.post_user.controller;

import com.ssafy.banjjak.global.BaseResponse;
import com.ssafy.banjjak.post_user.model.PostUserDto;
import com.ssafy.banjjak.post_user.service.PostUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/postuser")
@RequiredArgsConstructor
@CrossOrigin(origins = { "*" }, methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE} , maxAge = 6000)
public class PostUserController {
    private final PostUserService postUserService;

    @PostMapping
    public ResponseEntity<BaseResponse<?>> joinPost(@RequestBody PostUserDto postUserDto){
        postUserService.joinPost(postUserDto);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
