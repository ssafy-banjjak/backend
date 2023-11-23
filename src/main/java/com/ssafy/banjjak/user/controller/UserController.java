package com.ssafy.banjjak.user.controller;

import com.ssafy.banjjak.global.BaseResponse;
import com.ssafy.banjjak.user.model.UserLoginResponseDto;
import com.ssafy.banjjak.user.model.UserDto;
import com.ssafy.banjjak.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;


    @ApiOperation(value = "로그인")
    @PostMapping("/login")
    public ResponseEntity<BaseResponse<UserLoginResponseDto>> login(@RequestBody UserDto userDto) {
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>("로그인에 성공했습니다.", userService.login(userDto)));
    }

    @ApiOperation(value = "회원가입")
    @PostMapping("/signup")
    public ResponseEntity<BaseResponse<?>> signup(@RequestBody UserDto userDto) {
        userService.signup(userDto);
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>("회원가입에 성공했습니다.", null));
    }

    @ApiOperation(value = "유저 정보 조회")
    @GetMapping("/{userId}")
    public ResponseEntity<BaseResponse<UserDto>> getUserInfo(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>("유저 정보를 가져왔습니다.",userService.getUserinfo(userId)));
    }

    @ApiOperation(value = "로그아웃")
    @GetMapping("/logout/{userId}")
    public ResponseEntity<BaseResponse<?>> removeToken(@PathVariable ("userId") Long userId) {
        userService.deleteRefreshToken(userId);
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>("로그아웃 되었습니다.", null));

    }

    @ApiOperation(value = "토큰 재발급")
    @PostMapping("/reissue")
    public ResponseEntity<BaseResponse<UserLoginResponseDto>> refreshToken(@RequestBody Long userId, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse("토큰 재발급 되었습니다.",userService.reissue(userId, request)));
    }

}
