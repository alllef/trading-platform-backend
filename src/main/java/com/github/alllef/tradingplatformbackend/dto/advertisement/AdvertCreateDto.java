package com.github.alllef.tradingplatformbackend.dto.advertisement;

import com.github.alllef.tradingplatformbackend.entity.PhotoAdvert;
import com.github.alllef.tradingplatformbackend.entity.enums.AdvertType;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Set;

@Data
public class AdvertCreateDto {
    private Long authorId;
    private Long categoryId;
    private AdvertType advertType;
    private BigDecimal price;
    private String description;
    private String advertName;
}
