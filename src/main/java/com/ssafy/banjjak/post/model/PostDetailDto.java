package com.ssafy.banjjak.post.model;

import com.ssafy.banjjak.attraction.model.AttractionDto;
import com.ssafy.banjjak.post_attraction.model.PostAttractionDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
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
    private Timestamp dateTime;
    private Timestamp createDate;
    private String username;
    private List<AttractionDto> attractionDtoList;
    private int peopleCnt;
}
