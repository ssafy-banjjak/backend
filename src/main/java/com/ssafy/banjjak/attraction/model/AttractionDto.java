package com.ssafy.banjjak.attraction.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AttractionDto {

    private Long attractionId;
    private String region;
    private String name;
    private String description;
    private Double latitude;
    private Double longitude;
    private String type;
    private String image;
    private String tel;
}
