package com.ssafy.banjjak.post.model;

import com.ssafy.banjjak.attraction.model.AttractionDto;
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
    private Long postId;
    private Long userId;
    private String region;
    private String title;
    private String content;
    private int recruits;
    private String dateTime;
    private String createDate;
    private String username;
    private List<AttractionDto> attractionDtoList;
    private int peopleCnt;
}
