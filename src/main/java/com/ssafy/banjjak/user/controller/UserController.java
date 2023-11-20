package com.ssafy.banjjak.user.controller;

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
    public ResponseEntity<Map<String, Object>> login(@RequestBody UserDto userDto) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        log.info("userDto: {}", userDto);
        UserDto loginUser = userService.login(userDto);
        log.info("loginUser: {}", loginUser);
        if(loginUser != null) {
            resultMap.put("access_token", jwtUtil.createAccessToken(loginUser.getUserId()));
            String refreshToken = jwtUtil.createRefreshToken(loginUser.getUserId());
            resultMap.put("refresh_token", refreshToken);
            userService.saveRefreshToken(loginUser.getUserId(), refreshToken);
        }
        return ResponseEntity.status(HttpStatus.OK).body(resultMap);
    }

    @PostMapping("/signup")
    public ResponseEntity<Map<String, Object>> signup(@RequestBody UserDto userDto) {
        userService.signup(userDto);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserInfo(@PathVariable Long userId) {
        log.info("userId: {}", userId);
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserinfo(userId));
    }

    @GetMapping("/logout/{userId}")
    public ResponseEntity<?> removeToken(@PathVariable ("userId") Long userId) {
        Map<String, Object> resultMap = new HashMap<>();
        HttpStatus status = HttpStatus.ACCEPTED;
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
                log.debug("token : {}", accessToken);
                log.debug("정상적으로 액세스토큰 재발급!!!");
                resultMap.put("access_token", accessToken);
                status = HttpStatus.CREATED;
            }
        } else {
            log.debug("리프레쉬토큰도 사용불가!!!!!!!");
            status = HttpStatus.UNAUTHORIZED;
        }
        return new ResponseEntity<Map<String, Object>>(resultMap, status);
    }

}
