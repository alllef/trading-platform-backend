package com.github.alllef.tradingplatformbackend.dto.review;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ReviewCreateDto {
    private Long advertisementId;
    private Long reviewAuthorId;
    private String content;
    private BigDecimal mark;
}
