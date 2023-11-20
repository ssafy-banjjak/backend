package com.ssafy.banjjak.shorts.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ShortDto {

    private Long shortId;
    private Long userId;
    private String region;
    private String title;
    private String content;
    private Integer like;
    private Integer dislike;
    private Timestamp createDate;
    private String filePath;
    private String thumbnail;
}
