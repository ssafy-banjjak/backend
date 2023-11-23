package com.ssafy.banjjak.post.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PostDto {

    private Long postId;
    private Long userId;
    private String region;
    private String title;
    private String content;
    private int recruits;
    private String dateTime;
    private String createDate;
}
