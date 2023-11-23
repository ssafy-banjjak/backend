package com.ssafy.banjjak.post_user.service;

import com.ssafy.banjjak.post.model.PostDetailDto;
import com.ssafy.banjjak.post_user.model.PostUserDto;
import com.ssafy.banjjak.post_user.model.mapper.PostUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void unJoinPost(PostUserDto postUserDto) {
        postUserMapper.unJoinPost(postUserDto);
    }

    @Override
    public List<PostDetailDto> joinList(Long userId) {
        List<Long> postIdList = postUserMapper.userPostList(userId);
        List<PostDetailDto> list = new ArrayList<>();

        for (Long postId : postIdList) {
            list.add(postUserMapper.joinList(postId));
        }
        return list;
    }

    @Override
    public int canJoinPost(PostUserDto postUserDto) {
        return postUserMapper.canJoinPost(postUserDto);
    }
}
