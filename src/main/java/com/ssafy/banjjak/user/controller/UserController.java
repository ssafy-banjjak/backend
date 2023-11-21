package com.ssafy.banjjak.user.controller;

import com.ssafy.banjjak.global.BaseException;
import com.ssafy.banjjak.global.BaseResponse;
import com.ssafy.banjjak.shorts.model.UserLoginResponseDto;
import com.ssafy.banjjak.user.model.UserDto;
import com.ssafy.banjjak.user.service.UserService;
import com.ssafy.banjjak.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JWTUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<BaseResponse<UserLoginResponseDto>> login(@RequestBody UserDto userDto) {
        Map<String, Object> resultMap = new HashMap<>();
        UserDto loginUser = userService.login(userDto);
        String accessToken = jwtUtil.createAccessToken(loginUser.getUserId());
        String refreshToken = jwtUtil.createRefreshToken(loginUser.getUserId());
        resultMap.put("refreshToken", refreshToken);
        userService.saveRefreshToken(loginUser.getUserId(), refreshToken);
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>("로그인에 성공했습니다.", new UserLoginResponseDto(accessToken, refreshToken)));
    }

    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signup(@RequestBody UserDto userDto) {
        userService.signup(userDto);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<BaseResponse<UserDto>> getUserInfo(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>("유저 정보를 가져왔습니다.",userService.getUserinfo(userId)));
    }

    @GetMapping("/logout/{userId}")
    public ResponseEntity<?> removeToken(@PathVariable ("userId") Long userId) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status;
        try {
            userService.deleteRefreshToken(userId);
            status = HttpStatus.OK;
        } catch (Exception e) {
            log.error("로그아웃 실패 : {}", e);
            resultMap.put("message", e.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

    @PostMapping("/refresh")
    public ResponseEntity<?> refreshToken(@RequestBody UserDto userDto, HttpServletRequest request) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
        String token = request.getHeader("refreshToken");
        if (jwtUtil.checkToken(token)) {
            if (token.equals(userService.getRefreshToken(userDto.getUserId()))) {
                String accessToken = jwtUtil.createAccessToken(userDto.getUserId());
                resultMap.put("accessToken", accessToken);
                status = HttpStatus.CREATED;
            }
        } else {
            status = HttpStatus.UNAUTHORIZED;
            throw new BaseException(HttpStatus.UNAUTHORIZED.value(), "리프레쉬토큰 사용 불가!");
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

}
