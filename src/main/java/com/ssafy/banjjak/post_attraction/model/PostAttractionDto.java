package com.ssafy.banjjak.post_attraction.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PostAttractionDto {

    private Long postAttractionId;
    private Long attractionId;
    private Long postId;
}
