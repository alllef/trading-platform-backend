package com.github.alllef.tradingplatformbackend.dto.review;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ReviewUpdateDto {
    private Long reviewId;
    private String content;
    private BigDecimal mark;
}
