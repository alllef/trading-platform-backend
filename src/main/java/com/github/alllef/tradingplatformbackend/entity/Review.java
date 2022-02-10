package com.github.alllef.tradingplatformbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(nullable = false,name = "advertisement_id")
    private Advertisement advertisement;

    private String content;

    @Column(nullable = false)
    private BigDecimal mark;

    @Column(nullable = false)
    private LocalDate creationDate;
}
