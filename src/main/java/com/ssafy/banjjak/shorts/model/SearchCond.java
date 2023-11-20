package com.ssafy.banjjak.shorts.model;

import lombok.Data;

@Data
public class SearchCond extends Pagination{
    private Long userId;
    private String region;
}
