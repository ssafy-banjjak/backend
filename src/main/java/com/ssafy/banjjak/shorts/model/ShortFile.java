package com.ssafy.banjjak.shorts.model;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShortFile {
    private Long userId;
    private String region;
    private String title;
    private String content;
    private MultipartFile image;
    private MultipartFile video;
}
