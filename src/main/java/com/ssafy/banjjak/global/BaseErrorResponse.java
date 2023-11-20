package com.ssafy.banjjak.global;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseErrorResponse {
    private int status;
    private String message;
}
