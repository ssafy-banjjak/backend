package com.ssafy.banjjak.shorts.model;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
