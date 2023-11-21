package com.ssafy.banjjak.post.model;

import com.ssafy.banjjak.attraction.model.AttractionDto;
import com.ssafy.banjjak.post_attraction.model.PostAttractionDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PostDetailDto {
    private PostDto postDto;
    private List<AttractionDto> attractionDtoList;
    private int peopleCnt;
}
