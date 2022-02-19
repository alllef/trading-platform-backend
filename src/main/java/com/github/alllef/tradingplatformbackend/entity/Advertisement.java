package com.github.alllef.tradingplatformbackend.entity;

import com.github.alllef.tradingplatformbackend.dto.GetDtoConverter;
import com.github.alllef.tradingplatformbackend.dto.advertisement.AdvertGetDto;
import com.github.alllef.tradingplatformbackend.entity.enums.AdvertType;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Advertisement implements GetDtoConverter<AdvertGetDto> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AdvertType type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(nullable = false)
    private LocalDate creationDate;

    private LocalDate closeDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "moderator_closed_id")
    private User closedByModerator;

    @Column(nullable = false)
    private String advertName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "currency_id", nullable = false)
    private Currency currency;

    @Column(columnDefinition = "boolean default true")
    private Boolean isActive;

    @OneToMany(mappedBy = "advertisement", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<PhotoAdvert> photos;

    @OneToMany(mappedBy = "advertisement", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Review> reviews;

    public AdvertGetDto toGetDto(){
        return AdvertGetDto.builder()
                .id(id)
                .type(type)
                .author(author)
                .price(price)
                .description(description)
                .category(category)
                .creationDate(creationDate)
                .closeDate(closeDate)
                .closedByModerator(closedByModerator)
                .advertName(advertName)
                .currency(currency)
                .isActive(isActive)
                .build();
    }
}