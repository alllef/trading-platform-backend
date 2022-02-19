package com.github.alllef.tradingplatformbackend.dto.advertisement;

import com.github.alllef.tradingplatformbackend.entity.Category;
import com.github.alllef.tradingplatformbackend.entity.Currency;
import com.github.alllef.tradingplatformbackend.entity.User;
import com.github.alllef.tradingplatformbackend.entity.enums.AdvertType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class AdvertGetDto {
    private Long id;
    private AdvertType type;
    private User author;
    private BigDecimal price;
    private String description;
    private Category category;
    private LocalDate creationDate;
    private LocalDate closeDate;
    private User closedByModerator;
    private String advertName;
    private Currency currency;
    private Boolean isActive;
}
