package com.ssafy.banjjak.post_user.service;

import com.ssafy.banjjak.post_user.model.PostUserDto;
import com.ssafy.banjjak.post_user.model.mapper.PostUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PostUserServiceImpl implements PostUserService{
    private final PostUserMapper postUserMapper;


    @Override
    public void joinPost(PostUserDto postUserDto) {
        postUserMapper.joinPost(postUserDto);
    }
}
