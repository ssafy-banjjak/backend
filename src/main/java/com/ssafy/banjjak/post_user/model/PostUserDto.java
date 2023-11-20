package com.ssafy.banjjak.post_user.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PostUserDto {

    private Long postUserId;
    private Long postId;
    private Long userId;
}
