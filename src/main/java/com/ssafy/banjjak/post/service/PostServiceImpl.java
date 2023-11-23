package com.ssafy.banjjak.post.service;

import com.ssafy.banjjak.attraction.model.AttractionDto;
import com.ssafy.banjjak.post.model.PostDetailDto;
import com.ssafy.banjjak.post.model.PostDto;
import com.ssafy.banjjak.post.model.PostWrtieDto;
import com.ssafy.banjjak.post.model.mapper.PostMapper;
import com.ssafy.banjjak.post_attraction.model.PostAttractionDto;
import com.ssafy.banjjak.post_attraction.model.mapper.PostAttractionMapper;
import com.ssafy.banjjak.post_user.model.PostUserDto;
import com.ssafy.banjjak.post_user.model.mapper.PostUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final PostMapper postMapper;
    private final PostAttractionMapper postAttractionMapper;
    private final PostUserMapper postUserMapper;

    @Override
    public List<PostDetailDto> listPost(Map<String, String> map) {
        Map<String, Object> param = new HashMap<>();
        param.put("region", map.get("region") == null ? "" : map.get("region"));
        param.put("word", map.get("word") == null ? "" : map.get("word"));
        return postMapper.listPost(param);
    }

    @Override
    public void writePost(PostWrtieDto postWrtieDto) {
        PostDto postDto = postWrtieDto.getPostDto();
        List<PostAttractionDto> postAttractionDtoList = postWrtieDto.getPostAttractionDtoList();
        postMapper.writePost(postDto);
        Long postId = postDto.getPostId();
        for (PostAttractionDto postAttractionDto : postAttractionDtoList) {
            postAttractionDto.setPostId(postId);
        }
        postAttractionMapper.writeAttraction(postAttractionDtoList);

    }

    @Override
    public PostDetailDto detailPost(Long postId) throws Exception {
        PostDetailDto postDetailDto = postMapper.detailPost(postId);
        List<AttractionDto> attractionDtoList = postAttractionMapper.getAttraction(postId);
        List<PostUserDto> postUserDtoList = postUserMapper.getPostUser(postId);

        postDetailDto.setAttractionDtoList(attractionDtoList);
        postDetailDto.setPeopleCnt(postUserDtoList.size());

        return postDetailDto;
    }

    @Override
    public void deletePost(Long postId) {
        postMapper.deletePost(postId);
    }

}
